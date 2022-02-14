package magazine.persistence.dao.services.interfaces;

import magazine.persistence.model.Journal;

import java.util.List;

public interface JournalSimpleService {
    List<Journal> findAllJournals() throws InterruptedException;

    Journal addJournal(Journal journal);

    Journal getJournalById(long id);
}
