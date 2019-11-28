package edu.xpu.journey.controller.show;

import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.service.CountService;
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
    private CountService countService;

    @GetMapping
    public String getIndex(ModelMap modelMap){
        modelMap.addAttribute("blogTitle", "Tim的空间");
        modelMap.addAttribute("articleCount", countService.getArticleCountByStatus(ArticleStatusEnum.RELEASE.getCode()));
        modelMap.addAttribute("discussCount", countService.getDiscussCount());
        modelMap.addAttribute("loveCount", countService.getLoveCount());
        modelMap.addAttribute("readingCount", countService.getReadingCount());
        return "view/index";
    }
}
