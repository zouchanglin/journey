package edu.xpu.journey.controller.show;

import edu.xpu.journey.convert.ArticleInfoConvert;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.service.CountService;
import edu.xpu.journey.vo.ArticleInfoVO;
import edu.xpu.journey.vo.SideBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 长林
 */
@Controller
@RequestMapping("/")
public class ShowIndexController {
    @Autowired
    private CountService countService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleInfoConvert articleInfoConvert;

    @GetMapping
    public String getIndex(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "5") Integer size,
                           ModelMap modelMap){
        SideBarVO countDataPackage = countService.getCountDataPackage();
        //侧边栏打包数据
        modelMap.addAttribute("dataPackage", countDataPackage);
        List<ArticleInfo> pageArticleList = articleService.getPageArticleList(ArticleStatusEnum.RELEASE.getCode(), page, size);
        List<ArticleInfoVO> articleInfoVOList = articleInfoConvert.convertList(pageArticleList);
        System.out.println(articleInfoVOList);
        //分页
        Integer totalCount = articleService.getArticleCountByStatus(ArticleStatusEnum.RELEASE.getCode());

        //计算分页参数
        int totalPage = (totalCount + size - 1) / size;
        //传递分页参数
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        modelMap.addAttribute("totalPage", totalPage-1);

        modelMap.addAttribute("articles", articleInfoVOList);
        return "view/index";
    }
}
