package edu.xpu.journey.controller.admin;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.show.StrArticleInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class IndexController {
    private final ArticleService articleService;

    public IndexController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 后台管理首页
     * @return 后台管理中心的页面
     */
    @GetMapping("/center")
    public String center(){
        return "admin/center";
    }

    /**
     * 后台博客管理首页
     * @return 博客管理列表
     */
    @GetMapping("/blog_list")
    public String blogList(@RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                           Map<String, Object> map){
        List<ArticleInfo> debugList = articleService.getPageArticleList(ArticleStatusEnum.DEBUG.getCode(), pageIndex, 10);
        map.put("debugList", StrArticleInfo.convert(debugList));
        List<ArticleInfo> releaseList = articleService.getPageArticleList(ArticleStatusEnum.RELEASE.getCode(), pageIndex, 10);
        map.put("releaseList", StrArticleInfo.convert(releaseList));
        List<ArticleInfo> deleteList = articleService.getPageArticleList(ArticleStatusEnum.DELETE.getCode(), pageIndex, 10);
        map.put("deleteList", StrArticleInfo.convert(deleteList));
        return "admin/blogList";
    }

    /**
     * 后台评论管理首页
     * @param map 页面参数
     * @return 评论管理列表
     */
    @GetMapping("/discuss_list")
    public String discussList(Map<String, Object> map){
        return "admin/discussList";
    }
}