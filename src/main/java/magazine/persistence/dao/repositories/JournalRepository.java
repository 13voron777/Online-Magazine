package magazine.persistence.dao.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import magazine.persistence.model.Journal;

import java.util.List;

@Repository
@Transactional
public interface JournalRepository extends CrudRepository<Journal, Long> {
    @Modifying
    @Query(value = "INSERT INTO users_journal(username, journal_id) VALUES (?1, ?2)",
            nativeQuery = true)
    void subscribeJournal(String userName, Long idJournal);

    Journal getJournalById(Long id);

    @Modifying
    @Query(value = "UPDATE journals SET name = ?2, description = ?3 WHERE journal_id = ?1",
    nativeQuery = true)
    void updateJournal(long id, String name, String description);

    @Modifying
    @Query(value = "DELETE FROM users_journal WHERE username = ?1 and journal_id = ?2",
            nativeQuery = true)
    void unsubscribeJournal(String userName, Long idJournal);

    @Query(value = "SELECT journal_id FROM users_journal WHERE username = ?",
            nativeQuery = true)
    List<Long> listAllSubJournalsIds(String userName);
}
