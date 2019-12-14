package edu.xpu.journey.controller.admin;

import edu.xpu.journey.VO.ArticleInfoVO;
import edu.xpu.journey.convert.ArticleInfoConvert;
import edu.xpu.journey.elasticsearch.service.EsArticleSearchService;
import edu.xpu.journey.entity.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author x
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private EsArticleSearchService esArticleSearchService;
    @Autowired
    private ArticleInfoConvert articleInfoConvert;

    @RequestMapping("/article")
    public String searchArticle(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                Map<String, Object> map){
        List<ArticleInfo> searchResult = esArticleSearchService.searchKeyWord(keyword);
        List<ArticleInfoVO> articleInfoVOList = articleInfoConvert.convertList(searchResult);
        map.put("list", articleInfoVOList);
        return "/admin/article/list-search";
    }
}
