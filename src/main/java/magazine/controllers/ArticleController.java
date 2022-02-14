package magazine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import magazine.persistence.dao.services.interfaces.ArticleSimpleService;
import magazine.persistence.model.Article;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleSimpleService articleSimpleService;

    @GetMapping(value = "/all")
    public ModelAndView listAllArticles(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("article", articleSimpleService.findAllArticles());
        modelAndView.setViewName("article/articles");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewArticle(HttpServletRequest request) {
        Article article = new Article();
        article.setId(Long.parseLong(request.getParameter("id")));
        article.setHeader(request.getParameter("header"));
        article.setContent(request.getParameter("content"));
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
