package magazine.persistence.dao.repositories;

import magazine.persistence.model.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import magazine.persistence.model.Journal;

@Repository
@Transactional
public interface JrnlRepository extends CrudRepository<Journal, Long> {
    @Modifying
    @Query(value = "INSERT INTO users_journal(username, journal_id) VALUES (?1, ?2)",
            nativeQuery = true)
    void subscribeJournal(String userName, Long idJournal);

    Journal getJournalById(Long id);

    @Modifying
    @Query(value = "DELETE FROM users_journal where username = ?1 and journal_id = ?2",
            nativeQuery = true)
    void unsubscribeJournal(String userName, Long idJournal);
}
