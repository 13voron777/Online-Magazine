package magazine.persistence.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import magazine.persistence.model.Article;

@Repository
@Transactional
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
