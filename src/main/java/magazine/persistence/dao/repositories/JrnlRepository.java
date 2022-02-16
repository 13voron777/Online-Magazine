package magazine.persistence.dao.repositories;

import magazine.persistence.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import magazine.persistence.model.Journal;

import java.util.List;

@Repository
@Transactional
public interface JrnlRepository extends CrudRepository<Journal, Long> {
    Journal getJournalById(long id);
}
