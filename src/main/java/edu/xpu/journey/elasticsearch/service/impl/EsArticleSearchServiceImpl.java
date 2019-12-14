package edu.xpu.journey.elasticsearch.service.impl;

import edu.xpu.journey.elasticsearch.repository.EsArticleInfoRepository;
import edu.xpu.journey.elasticsearch.service.EsArticleSearchService;
import edu.xpu.journey.entity.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author x
 */
@Service
public class EsArticleSearchServiceImpl implements EsArticleSearchService {
    @Autowired
    private EsArticleInfoRepository repository;

    @Override
    public List<ArticleInfo> searchKeyWord(String keyword) {
        return repository.findDistinctByTittleContainingOrSummaryContainingOrContentContaining(
                keyword, keyword, keyword);
    }
}