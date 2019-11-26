package edu.xpu.journey.controller.admin;

import com.google.common.collect.Lists;
import edu.xpu.journey.config.FileUpLoadConfig;
import edu.xpu.journey.convert.ArticleInfoConvert;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.form.ArticleFrom;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.service.CategoryService;
import edu.xpu.journey.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    @Autowired
    private FileUpLoadConfig fileUpLoadConfig;

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
        map.put("checkedTag", tagService.getArticleTag(articleId));
        map.put("uncheckedTag", tagService.getOtherTags(articleId));
        return "admin/editArticle";
    }

    /**
     * 后台博客管理首页
     * @return 博客管理列表
     */
    @GetMapping("/list")
    public String articleList(@RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                           Map<String, Object> map){
        //总数
        int totalCount = articleService.getArticleCountByStatus(ArticleStatusEnum.RELEASE.getCode());
        //每页加载数
        int loadCount = 2;
        //总页数
        int totalPage = (totalCount + loadCount-1) / loadCount;

        List<ArticleInfo> releaseList = articleService.getPageArticleList(ArticleStatusEnum.RELEASE.getCode(), pageIndex, loadCount);
        map.put("releaseList", articleInfoConvert.convertList(releaseList));

        //传递总页数
        List<Integer> pageList = Lists.newArrayList();
        for (int i = 0; i < totalPage; i++) {pageList.add(i);}
        map.put("totalPage", pageList);
        //传递当前页
        map.put("thisPage", pageIndex);

        return "admin/articleList";
    }

    @ResponseBody
    @PostMapping("/release")
    public String releaseArticle(Integer id, ArticleFrom articleFrom){
        ArticleInfo articleInfo = articleService.releaseArticle(id == null ? 0 : id, articleFrom);
        return fileUpLoadConfig.getBlogUrl()+"/admin/article/released/"+articleInfo.getId();
    }

    @GetMapping("/released/{articleId}")
    public String releasedArticle(@PathVariable("articleId") Integer articleId,
                                  Map<String, Object> map){
        ArticleInfo articleInfo = articleService.getArticleById(articleId);
        map.put("articleInfo", articleInfo);
        return "admin/releaseSuccess";
    }
}