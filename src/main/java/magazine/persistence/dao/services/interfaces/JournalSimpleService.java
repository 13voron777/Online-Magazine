package magazine.persistence.dao.services.interfaces;

import magazine.persistence.model.Journal;

import java.util.List;

public interface JournalSimpleService {
    List<Journal> findAllJournals() throws InterruptedException;

    List<Journal> findAllSubJournals(String userName);

    Journal addJournal(Journal journal);

    Journal getJournalById(long id);

    void updateJournal(long id, String name, String description);

    void removeById(long id);

    void subscribeJournal(String userName, Long idJournal);

    boolean isSubscripted(String userName, Long idJournal);

    void unsubscribeJournal(String userName, Long idJournal);
}
