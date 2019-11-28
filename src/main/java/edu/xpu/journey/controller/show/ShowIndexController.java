package edu.xpu.journey.controller.show;

import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 长林
 */
@Controller
@RequestMapping("/")
public class ShowIndexController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String getIndex(ModelMap modelMap){
        modelMap.addAttribute("blogTitle", "Tim的空间");
        Integer articleCount = articleService.getArticleCountByStatus(ArticleStatusEnum.RELEASE.getCode());
        modelMap.addAttribute("articleCount", articleCount);


        return "view/index";
    }
}
