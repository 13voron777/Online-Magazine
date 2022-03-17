package magazine.controllers;

import magazine.persistence.dao.services.interfaces.JournalSimpleService;
import magazine.persistence.model.Journal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalSimpleService journalSimpleService;

    @GetMapping(value = "/all")
    public ModelAndView listAllJournals(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("journal", journalSimpleService.findAllJournals());
        modelAndView.setViewName("journal/journals");
        return modelAndView;
    }

    @GetMapping(value = "/sub_journals")
    public ModelAndView listAllSubJournals(ModelAndView modelAndView) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("journal", journalSimpleService.findAllSubJournals(userName));
        modelAndView.setViewName("journal/sub_journals");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewJournal(HttpServletRequest request) {
        Journal journal = new Journal();
        journal.setName(request.getParameter("name"));
        journal.setDescription(request.getParameter("description"));
        journalSimpleService.addJournal(journal);
        return "redirect: all";
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET, params = {"id"})
    public ModelAndView listJournalByLink(@RequestParam(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("journal", journalSimpleService.getJournalById(id));
        modelAndView.setViewName("journal/jrnl_item");
        return modelAndView;
    }

    @RequestMapping(value = "/getupdate", method = RequestMethod.GET, params = {"id"})
    public ModelAndView listUpdate(@RequestParam(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("journal", journalSimpleService.getJournalById(id));
        modelAndView.setViewName("journal/update_journal");
        return modelAndView;
    }

    @PostMapping(value = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id") long id, HttpServletRequest request,
                         ModelAndView modelAndView) {
        journalSimpleService.updateJournal(id, request.getParameter("name"),
                request.getParameter("description"));
        modelAndView.addObject("journal", journalSimpleService.getJournalById(id));
        return listJournalByLink(id, modelAndView);
    }

    @PostMapping(value = "/remove/{id}")
    public ModelAndView remove(@PathVariable long id, ModelAndView modelAndView) throws InterruptedException {
        journalSimpleService.removeById(id);
        modelAndView.addObject("journal", journalSimpleService.getJournalById(id));
        return listAllJournals(modelAndView);
    }

    @PostMapping(value = "/subscribe/{id}")
    public ModelAndView subscribe(@PathVariable long id, ModelAndView modelAndView) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!journalSimpleService.isSubscripted(userName, id)) {
            journalSimpleService.subscribeJournal(userName, id);
        }
        modelAndView.addObject("journal", journalSimpleService.getJournalById(id));
        return listJournalByLink(id, modelAndView);
    }

    @PostMapping(value = "/unsubscribe/{id}")
    public ModelAndView unsubscribe(@PathVariable long id, ModelAndView modelAndView) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (journalSimpleService.isSubscripted(userName, id)) {
            journalSimpleService.unsubscribeJournal(userName, id);
        }
        modelAndView.addObject("journal", journalSimpleService.getJournalById(id));
        return listJournalByLink(id, modelAndView);
    }
}
