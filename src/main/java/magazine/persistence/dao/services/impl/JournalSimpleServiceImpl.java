package magazine.persistence.dao.services.impl;

import com.google.common.collect.Lists;
import magazine.persistence.dao.repositories.JrnlRepository;
import magazine.persistence.dao.services.interfaces.JournalSimpleService;
import magazine.persistence.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalSimpleServiceImpl implements JournalSimpleService {
    private JrnlRepository jrnlRepository;

    @Override
    public List<Journal> findAllJournals() throws InterruptedException {
        return Lists.newArrayList(jrnlRepository.findAll());
    }

    @Override
    public Journal addJournal(Journal journal) {
        return jrnlRepository.save(journal);
    }

    @Override
    public Journal getJournalById(long id){
        return jrnlRepository.getJournalById(id);
    }

    @Autowired
    public void setJrnlRepository(JrnlRepository jrnlRepository) {
        this.jrnlRepository = jrnlRepository;
    }
}
