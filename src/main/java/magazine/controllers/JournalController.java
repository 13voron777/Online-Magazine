package magazine.controllers;

import magazine.persistence.dao.services.interfaces.JournalSimpleService;
import magazine.persistence.model.Journal;
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

    @PostMapping(value = "/add")
    public String addNewJournal(HttpServletRequest request) {
        Journal journal = new Journal();
        journal.setId(Long.parseLong(request.getParameter("id")));
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
}
