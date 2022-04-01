package magazine.persistence.dao.services.impl;

import com.google.common.collect.Lists;
import magazine.persistence.dao.repositories.JournalRepository;
import magazine.persistence.dao.services.interfaces.JournalSimpleService;
import magazine.persistence.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalSimpleServiceImpl implements JournalSimpleService {
    private JournalRepository journalRepository;

    @Override
    public List<Journal> findAllJournals() {
        return Lists.newArrayList(journalRepository.findAll());
    }

    @Override
    public Journal addJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public Journal getJournalById(long id){
        return journalRepository.getJournalById(id);
    }

    @Override
    public void updateJournal(long id, String name, String description) {
        journalRepository.updateJournal(id, name, description);
    }

    @Override
    public void removeById(long id) {
        journalRepository.deleteById(id);
    }

    @Override
    public void subscribeJournal(String userName, Long idJournal) {
        journalRepository.subscribeJournal(userName, idJournal);
    }

    @Override
    public List<Journal> findAllSubJournals(String userName) {
        List<Long> journals_id = journalRepository.listAllSubJournalsIds(userName);
        List<Journal> journals = new ArrayList<>();
        for (long id : journals_id) {
            journals.add(getJournalById(id));
        }
        return journals;
    }

    @Override
    public boolean isSubscribed(String userName, Long idJournal) {
        return journalRepository.listAllSubJournalsIds(userName).contains(idJournal);
    }

    @Override
    public void unsubscribeJournal(String userName, Long idJournal) {
        journalRepository.unsubscribeJournal(userName, idJournal);
    }

    @Autowired
    public void setJrnlRepository(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }
}
