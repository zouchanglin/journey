package edu.xpu.journey.elasticsearch.repository;

import edu.xpu.journey.elasticsearch.entity.EsArticleInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author x
 */
public interface EsArticleInfoRepository extends ElasticsearchRepository<EsArticleInfo, Integer> {
    /**
     * 查找文章
     * @param tittle 文章标题
     * @param summary 文章摘要
     * @param content 文章内容
     * @param pageable 分页参数
     * @return 文章列表
     */
    Page<EsArticleInfo> findDistinctByTittleContainingOrSummaryContainingOrContentContaining(
            String tittle, String summary, String content, Pageable pageable);
}
