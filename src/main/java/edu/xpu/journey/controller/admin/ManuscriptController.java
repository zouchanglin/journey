package edu.xpu.journey.controller.admin;

import com.google.common.collect.Lists;
import edu.xpu.journey.convert.ArticleInfoConvert;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author 长林
 */
@Controller
@RequestMapping("/admin/manuscript")
public class ManuscriptController {
    private final ArticleService articleService;
    private final ArticleInfoConvert articleInfoConvert;

    public ManuscriptController(ArticleService articleService, ArticleInfoConvert articleInfoConvert) {
        this.articleService = articleService;
        this.articleInfoConvert = articleInfoConvert;
    }


    /**
     * 后台博客管理首页
     * @return 博客管理列表
     */
    @GetMapping("/list")
    public String articleList(@RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                              Map<String, Object> map){
        //总数
        int totalCount = articleService.getArticleCountByStatus(ArticleStatusEnum.DEBUG.getCode());
        //每页加载数
        int loadCount = 5;
        //总页数
        int totalPage = (totalCount + loadCount-1) / loadCount;

        List<ArticleInfo> releaseList = articleService.getPageArticleList(ArticleStatusEnum.DEBUG.getCode(), pageIndex, loadCount);
        map.put("manuscriptLists", articleInfoConvert.convertList(releaseList));

        //传递总页数
        List<Integer> pageList = Lists.newArrayList();
        for (int i = 0; i < totalPage; i++) {pageList.add(i);}
        map.put("totalPage", pageList);
        //传递当前页
        map.put("thisPage", pageIndex);

        return "admin/manuscriptList";
    }



    @GetMapping("/release/{article}")
    public String manuscriptToRelease(@PathVariable("article") Integer article){
        articleService.releaseArticleByManuscript(article);
        return "redirect:/admin/manuscript/list";
    }

    @GetMapping("/torecycle/{article}")
    public String manuscriptToRecycle(@PathVariable("article") Integer article){
        articleService.articleToRecycle(article);
        return "redirect:/admin/manuscript/list";
    }
}
