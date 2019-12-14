package edu.xpu.journey.elasticsearch.service;

import edu.xpu.journey.entity.ArticleInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author x
 */
public interface EsArticleSearchService {
    /**
     * 根据关键字搜索文章
     * @param keyword 关键字
     * @return 文章视图对象集合
     */
    List<ArticleInfo> searchKeyWord(String keyword);
}
