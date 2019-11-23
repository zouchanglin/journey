package edu.xpu.journey.service.impl;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public ArticleInfo getArticleById(Integer articleId) {
        return articleInfoMapper.findOneById(articleId);
    }

    @Override
    public List<ArticleInfo> getPageArticleList(Integer status, Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return articleInfoMapper.findPageByStatus(status, start, pageSize);
    }

    @Override
    public void articleToRecycle(Integer articleId) {
        int updateResult = articleInfoMapper.updateArticleStatus(ArticleStatusEnum.DELETE.getCode(), articleId);
        log.info("[ArticleServiceImpl] articleToRecycle updateResult={}", updateResult);
    }
}
