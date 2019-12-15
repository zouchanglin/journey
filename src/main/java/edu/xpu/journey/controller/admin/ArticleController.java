package edu.xpu.journey.controller.admin;

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

import java.util.List;
import java.util.Map;

/**
 * @author x
 */
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


    //TODO 预览文章
    @GetMapping("/preview/{articleId}")
    public String previewArticle(@PathVariable("articleId") String articleId){
        return articleId+"";
    }

    @GetMapping("/new")
    public String newArticle(Map<String, Object> map){
        map.put("category", categoryService.getAll());
        map.put("uncheckedTag", tagService.getAllTags());
        return "admin/edit/edit-new-article";
    }

    /**
     * 把文章移入回收站
     * @param articleId 文章编号
     * @return 刷新文章列表
     */
    @GetMapping(value = "/torecycle/{articleId}")
    public String articleToRecycle(@PathVariable("articleId") String articleId){
        articleService.articleToRecycle(Integer.parseInt(articleId));
        return "redirect:/admin/article/list";
    }

    /**
     * 把文章移入草稿箱
     * @param articleId 文章编号
     * @return 刷新文章列表
     */
    @GetMapping("/tomanuscript/{articleId}")
    public String articleToManuscript(@PathVariable("articleId") String articleId){
        articleService.articleToManuscript(Integer.parseInt(articleId));
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
        return "admin/edit/edit-article";
    }

    /**
     * 后台博客管理首页
     * @return 博客管理列表
     */
    @GetMapping("/list")
    public String articleList(@RequestParam(required = false, defaultValue = "1") Integer page,
                              @RequestParam(required = false, defaultValue = "10") Integer size,
                           @RequestParam(required = false, defaultValue = "RELEASE") String status,
                           Map<String, Object> map){
        //总数
        int totalCount = 0;
        List<ArticleInfo> articleList;
        if("RELEASE".equals(status)){
            articleList = articleService.getPageArticleList(ArticleStatusEnum.RELEASE.getCode(), page-1, size);
            totalCount = articleService.getArticleCountByStatus(ArticleStatusEnum.RELEASE.getCode());
        }else if("DEBUG".equals(status)){
            articleList = articleService.getPageArticleList(ArticleStatusEnum.DEBUG.getCode(), page-1, size);
            totalCount = articleService.getArticleCountByStatus(ArticleStatusEnum.DEBUG.getCode());
        }else{
            articleList = articleService.getPageArticleList(ArticleStatusEnum.DELETE.getCode(), page-1, size);
            totalCount = articleService.getArticleCountByStatus(ArticleStatusEnum.DELETE.getCode());
        }

        //总页数
        int totalPage = (totalCount + size - 1) / size;
        map.put("list", articleInfoConvert.convertList(articleList));
        //传递总页数
        map.put("totalPage", totalPage);
        //传递当前页
        map.put("currentPage", page);
        map.put("size", size);

        if("RELEASE".equals(status)){
            return "admin/article/list";
        }else if("DEBUG".equals(status)){
            return "admin/article/list-manu";
        }else{
            return "admin/article/list-recy";
        }
    }

    /**
     * 发布文章
     * @param id 文章Id
     * @param articleFrom 文章表单数据
     * @return 重新加载页面的地址
     */
    @ResponseBody
    @PostMapping("/release")
    public String releaseArticle(Integer id, ArticleFrom articleFrom){
        ArticleInfo articleInfo = articleService.releaseArticle((id == null ? 0 : id), articleFrom);
        return fileUpLoadConfig.getBlogUrl()+"/admin/article/released/"+articleInfo.getId();
    }

    /**
     * 保存文章为草稿
     * @param id 文章Id
     * @param articleFrom 文章表单数据
     * @return 重新加载页面的地址
     */
    @ResponseBody
    @PostMapping("/manuscript")
    public String saveManuscript(Integer id, ArticleFrom articleFrom){
        ArticleInfo articleInfo = articleService.saveManuscript((id == null ? 0 : id), articleFrom);
        return fileUpLoadConfig.getBlogUrl()+"/admin/article/saved/"+articleInfo.getId();
    }

    /**
     * 发布文章成功预览地址
     * @param articleId 文章的Id
     * @param map 向页面传递的参数
     * @return 成功页面
     */
    @GetMapping("/released/{articleId}")
    public String releasedArticle(@PathVariable("articleId") Integer articleId,
                                  Map<String, Object> map){
        ArticleInfo articleInfo = articleService.getArticleById(articleId);
        map.put("articleInfoStr", articleInfoConvert.articleToStr(articleInfo));
        map.put("msg", "《" + articleInfo.getTittle() + "》发布成功  ");
        map.put("url", "/admin/article/list");
        return "admin/common/success";
    }

    /**
     * 保存文章为草稿成功预览地址
     * @param articleId 文章的Id
     * @param map 向页面传递的参数
     * @return 成功页面
     */
    @GetMapping("/saved/{articleId}")
    public String savedArticle(@PathVariable("articleId") Integer articleId,
                                  Map<String, Object> map){
        ArticleInfo articleInfo = articleService.getArticleById(articleId);
        map.put("articleInfoStr", articleInfoConvert.articleToStr(articleInfo));
        map.put("tittle", "《" + articleInfo.getTittle() + "》保存成功");
        return "admin/common/success";
    }

    @GetMapping("/manuscript/release/{article}")
    public String manuscriptToRelease(@PathVariable("article") Integer article){
        articleService.releaseArticleByManuscript(article);
        return "redirect:/admin/article/list?status=DEBUG";
    }

    @GetMapping("/manuscript/torecycle/{article}")
    public String manuscriptToRecycle(@PathVariable("article") Integer article){
        articleService.articleToRecycle(article);
        return "redirect:/admin/article/list?status=DEBUG";
    }

    @GetMapping("/recycle/delete/{article}")
    public String deleteReally(@PathVariable("article") Integer article){
        articleService.reallyDelete(article);
        return "redirect:/admin/article/list?status=DELETE";
    }
    /**
     * 回收站到草稿箱
     * @param article 文章编号
     * @return 移动结果
     */
    @GetMapping("/recycle/tomanuscript/{article}") //localhost:8080/admin/recycle/tomanuscript/1
    public String toManuscript(@PathVariable("article") Integer article){
        articleService.articleToManuscript(article);
        return "redirect:/admin/article/list?status=DELETE";
    }
}