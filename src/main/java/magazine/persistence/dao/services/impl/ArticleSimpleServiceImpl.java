package magazine.persistence.dao.services.impl;

import com.google.common.collect.Lists;
import magazine.persistence.dao.repositories.ArticleRepository;
import magazine.persistence.dao.repositories.JrnlRepository;
import magazine.persistence.dao.services.interfaces.ArticleSimpleService;
import magazine.persistence.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleSimpleServiceImpl implements ArticleSimpleService {
    private ArticleRepository articleRepository;
    private JrnlRepository jrnlRepository;

    @Override
    public List<Article> findAllArticles() throws InterruptedException {
        return Lists.newArrayList(articleRepository.findAll());
    }

    @Override
    public List<Article> findAllSubArticles(String username) throws InterruptedException {
        List<Integer> journals_id = jrnlRepository.listAllSubJournals(username);
        List<Article> allArticles = findAllArticles();
        List<Article> result = new ArrayList<>();
        for (Article article : allArticles) {
            for (int id : journals_id) {
                if (article.getJournal().getId() == id) {
                    result.add(article);
                }
            }
        }
        return result;
    }

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getArticleById(long id){
        return articleRepository.getArticleById(id);
    }

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Autowired
    public void setJrnlRepository(JrnlRepository jrnlRepository) {
        this.jrnlRepository = jrnlRepository;
    }
}
