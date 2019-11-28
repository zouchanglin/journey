package edu.xpu.journey.service.impl;

import edu.xpu.journey.dao.DiscussInfoRepository;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Autowired
    private DiscussInfoRepository discussInfoRepository;

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
        return articleInfoMapper.countArticleReadingByStatus(ArticleStatusEnum.RELEASE.getCode());
    }

    @Override
    public int getLoveCount() {
        return articleInfoMapper.countArticleLoveByStatus(ArticleStatusEnum.RELEASE.getCode());
    }

    @Override
    public int getDiscussCount() {
        return (int)discussInfoRepository.count();
    }
}
