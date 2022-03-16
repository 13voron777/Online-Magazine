package magazine.persistence.dao.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import magazine.persistence.model.Article;

@Repository
@Transactional
public interface ArticleRepository extends CrudRepository<Article, Long> {
    Article getArticleById(long id);

    @Modifying
    @Query(value = "UPDATE articles SET header = ?2, content = ?3 WHERE article_id = ?1",
            nativeQuery = true)
    void updateArticle(long id, String header, String content);
}
