package magazine.persistence.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import magazine.persistence.model.Journal;

@Repository
@Transactional
public interface JrnlRepository extends CrudRepository<Journal, Long> {
    Journal getJournalById(long id);
}
