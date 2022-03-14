package magazine.persistence.dao.services.interfaces;

import magazine.persistence.model.Article;

import java.util.List;

public interface ArticleSimpleService {
    List<Article> findAllArticles() throws InterruptedException;

    List<Article> findAllSubArticles(String username) throws InterruptedException;

    Article addArticle(Article article);

    Article getArticleById(long id);
}
