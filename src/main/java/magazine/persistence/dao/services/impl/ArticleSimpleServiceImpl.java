package magazine.persistence.dao.services.impl;

import com.google.common.collect.Lists;
import magazine.persistence.dao.repositories.ArticleRepository;
import magazine.persistence.dao.services.interfaces.ArticleSimpleService;
import magazine.persistence.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleSimpleServiceImpl implements ArticleSimpleService {
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() throws InterruptedException {
        return Lists.newArrayList(articleRepository.findAll());
    }

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
}
