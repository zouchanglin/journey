package edu.xpu.journey.controller.admin;

import com.google.common.collect.Lists;
import edu.xpu.journey.config.FileUpLoadConfig;
import edu.xpu.journey.convert.ArticleInfoConvert;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.service.CategoryService;
import edu.xpu.journey.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin/recycle")
public class RecycleController {
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


    /**
     * 后台博客管理首页
     * @return 博客管理列表
     */
    @GetMapping("/list")
    public String articleList(@RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                              Map<String, Object> map){
        //总数
        int totalCount = articleService.getArticleCountByStatus(ArticleStatusEnum.DELETE.getCode());
        //每页加载数
        int loadCount = 5;
        //总页数
        int totalPage = (totalCount + loadCount-1) / loadCount;

        List<ArticleInfo> releaseList = articleService.getPageArticleList(ArticleStatusEnum.DELETE.getCode(), pageIndex, loadCount);
        map.put("releaseList", articleInfoConvert.convertList(releaseList));

        //传递总页数
        List<Integer> pageList = Lists.newArrayList();
        for (int i = 0; i < totalPage; i++) {pageList.add(i);}
        map.put("totalPage", pageList);
        //传递当前页
        map.put("thisPage", pageIndex);

        return "admin/recycledList";
    }

    /**
     * 后台博客管理首页
     * @return 博客管理列表
     */
    @GetMapping("/delete/{article}")
    public String deleteReally(@PathVariable("article") Integer article){
        articleService.reallyDelete(article);
        return "redirect:/admin/recycle/list";
    }

    /**
     * 回收站到草稿箱
     * @param article 文章编号
     * @return 移动结果
     */
    @GetMapping("/tomanuscript/{article}")
    public String toManuscript(@PathVariable("article") Integer article){
        articleService.articleToManuscript(article);
        return "redirect:/admin/recycle/list";
    }
}
