package magazine.controllers;

import magazine.persistence.dao.services.interfaces.JournalSimpleService;
import magazine.persistence.model.Journal;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import magazine.persistence.dao.services.interfaces.ArticleSimpleService;
import magazine.persistence.model.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleSimpleService articleSimpleService;

    @Autowired
    private JournalSimpleService journalSimpleService;

    @GetMapping(value = "/all")
    public ModelAndView listAllArticles(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("article", articleSimpleService.findAllArticles());
        modelAndView.setViewName("article/articles");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewArticle(HttpServletRequest request, Model model)
            throws InterruptedException {
        Article article = new Article();
        List<Journal> journals = journalSimpleService.findAllJournals();
        article.setId(Long.parseLong(request.getParameter("id")));
        article.setHeader(request.getParameter("header"));
        article.setContent(request.getParameter("content"));
        for (Journal journal: journals) {
            if (journal.getId() == Long.parseLong(request.getParameter("journal_id"))) {
                article.setJournal(journal);
                break;
            }
        }
        articleSimpleService.addArticle(article);
        return "redirect: all";
    }


    @RequestMapping(value = "/item", method = RequestMethod.GET, params = {"id"})
    public ModelAndView listArticleByLink(@RequestParam(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("article", articleSimpleService.getArticleById(id));
        modelAndView.setViewName("article/art_item");
        return modelAndView;
    }
}
