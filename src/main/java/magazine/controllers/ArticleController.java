package magazine.controllers;

import magazine.persistence.dao.services.interfaces.JournalSimpleService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import magazine.persistence.dao.services.interfaces.ArticleSimpleService;
import magazine.persistence.model.Article;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
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
        List<Article> articles = articleSimpleService.findAllArticles();
        Collections.reverse(articles);
        modelAndView.addObject("article", articles);
        modelAndView.setViewName("article/articles");
        return modelAndView;
    }

    @GetMapping(value = "/sub_articles")
    public ModelAndView listAllSubArticles(ModelAndView modelAndView) throws InterruptedException {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Article> subArticles = articleSimpleService.findAllSubArticles(userName);
        Collections.reverse(subArticles);
        modelAndView.addObject("article", subArticles);
        modelAndView.setViewName("article/sub_jrnl_articles");
        return modelAndView;
    }

    @RequestMapping(value = "/getAddArticle", method = RequestMethod.GET, params = {"id"})
    public ModelAndView listAddArticle(@RequestParam(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("journal", journalSimpleService.getJournalById(id));
        modelAndView.setViewName("article/create_article");
        return modelAndView;
    }

    @PostMapping(value = "/add/{id}")
    public ModelAndView addNewArticle(@PathVariable(value = "id") long id, HttpServletRequest request,
                                ModelAndView modelAndView) throws InterruptedException {
        Article article = new Article();
        article.setHeader(request.getParameter("header"));
        article.setContent(request.getParameter("content"));
        article.setJournal(journalSimpleService.getJournalById(id));
        articleSimpleService.addArticle(article);
        modelAndView.addObject("journal", article.getJournal());
        return listAllArticles(modelAndView);
    }


    @RequestMapping(value = "/item", method = RequestMethod.GET, params = {"id"})
    public ModelAndView listArticleByLink(@RequestParam(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("article", articleSimpleService.getArticleById(id));
        modelAndView.setViewName("article/art_item");
        return modelAndView;
    }

    @RequestMapping(value = "/getupdate", method = RequestMethod.GET, params = {"id"})
    public ModelAndView listUpdate(@RequestParam(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("article", articleSimpleService.getArticleById(id));
        modelAndView.setViewName("article/update_article");
        return modelAndView;
    }

    @PostMapping(value = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id") long id, HttpServletRequest request,
                               ModelAndView modelAndView) {
        articleSimpleService.updateArticle(id, request.getParameter("header"),
                request.getParameter("content"));
        modelAndView.addObject("article", articleSimpleService.getArticleById(id));
        return listArticleByLink(id, modelAndView);
    }

    @PostMapping(value = "/remove/{id}")
    public ModelAndView remove(@PathVariable long id, ModelAndView modelAndView) throws InterruptedException {
        articleSimpleService.removeById(id);
        modelAndView.addObject("article", articleSimpleService.getArticleById(id));
        return listAllArticles(modelAndView);
    }
}
