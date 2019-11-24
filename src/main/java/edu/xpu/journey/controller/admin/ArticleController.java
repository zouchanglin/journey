package edu.xpu.journey.controller.admin;

import edu.xpu.journey.convert.ArticleInfoConvert;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.TagInfo;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.service.CategoryService;
import edu.xpu.journey.service.TagService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleInfoConvert articleInfoConvert;

    @GetMapping("/recycle/{articleId}")
    public String articleToRecycle(@PathVariable("articleId") String articleId){
        articleService.articleToRecycle(Integer.parseInt(articleId));
        return "redirect:/admin/article/list";
    }

    /**
     * 请求编辑页面
     * @param articleId 文章编号
     * @return 编辑页面
     */
    @GetMapping("/edit/{articleId}")
    public String updateArticle(@PathVariable("articleId") Integer articleId,
                                Map<String, Object> map){
        ArticleInfo articleInfo = articleService.getArticleById(articleId);
        map.put("article", articleInfoConvert.articleToStr(articleInfo));
        map.put("category", categoryService.getAll());

        List<TagInfo> articleTag = tagService.getArticleTag(articleId);
        List<TagInfo> allTags = tagService.getAllTags();
        map.put("checkedTag", articleTag);

        HashSet<TagInfo> h1 = new HashSet<>(allTags);
        HashSet<TagInfo> h2 = new HashSet<>(articleTag);
        h1.removeAll(h2);
        List<TagInfo> surplus = Lists.newArrayList();
        surplus.addAll(h1);

        map.put("uncheckedTag", surplus);
        return "admin/editArticle";
    }

    /**
     * 后台博客管理首页
     * @return 博客管理列表
     */
    @GetMapping("/list")
    public String articleList(@RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                           Map<String, Object> map){
        List<ArticleInfo> releaseList = articleService.getPageArticleList(ArticleStatusEnum.RELEASE.getCode(), pageIndex, 10);
        map.put("releaseList", articleInfoConvert.convertList(releaseList));
        return "admin/articleList";
    }
}