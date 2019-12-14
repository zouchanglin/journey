package edu.xpu.journey.elasticsearch.repository;

import edu.xpu.journey.entity.ArticleInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author x
 */
public interface EsArticleInfoRepository extends ElasticsearchRepository<ArticleInfo, Integer> {
    /**
     * 查找文章
     * @param tittle 文章标题
     * @param summary 文章摘要
     * @param content 文章内容
     * @return 文章列表
     */
    List<ArticleInfo> findDistinctByTittleContainingOrSummaryContainingOrContentContaining(
            String tittle, String summary, String content);
}
