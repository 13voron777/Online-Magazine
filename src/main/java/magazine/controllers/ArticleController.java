package magazine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import magazine.persistence.dao.services.interfaces.ArticleSimpleService;

@Controller
public class ArticleController {

    @Autowired
    private ArticleSimpleService articleSimpleService;

    @GetMapping
    public ModelAndView listAllArticles(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("articles", articleSimpleService.findAll());
        //modelAndView.setViewName("index");
        return modelAndView;
    }

    /*
    <c:forEach items="${articles}" var="article">
        <div class="list_item">
            <span>${article.id}</span>
            <span>${article.header}</span>
            <span>${article.content}</span>
        </div>
    </c:forEach>
     */
}
