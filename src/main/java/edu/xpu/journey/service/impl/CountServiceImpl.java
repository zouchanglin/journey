package edu.xpu.journey.service.impl;

import edu.xpu.journey.dao.DiscussInfoRepository;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.CountService;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {
    private final ArticleInfoMapper articleInfoMapper;
    private final DiscussInfoRepository discussInfoRepository;

    public CountServiceImpl(DiscussInfoRepository discussInfoRepository, ArticleInfoMapper articleInfoMapper) {
        this.discussInfoRepository = discussInfoRepository;
        this.articleInfoMapper = articleInfoMapper;
    }

    @Override
    public int getArticleCount() {
        return articleInfoMapper.countArticles();
    }

    @Override
    public int getArticleCountByStatus(Integer articleStatus) {
        return articleInfoMapper.countArticleByStatus(articleStatus);
    }

    @Override
    public long getReadingCount() {
        Long ret = articleInfoMapper.countArticleReadingByStatus(ArticleStatusEnum.RELEASE.getCode());
        return ret == null ? 0:ret;
    }

    @Override
    public int getLoveCount() {
        Integer ret = articleInfoMapper.countArticleLoveByStatus(ArticleStatusEnum.RELEASE.getCode());
        return ret == null ? 0:ret;
    }

    @Override
    public int getDiscussCount() {
        //TODO 只统计发布文章的评论
        return (int)discussInfoRepository.count();
    }
}
