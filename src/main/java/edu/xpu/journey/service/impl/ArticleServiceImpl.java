package edu.xpu.journey.service.impl;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public List<ArticleInfo> getPageArticleList(Integer status, Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return articleInfoMapper.findPageByStatus(status, start, pageSize);
    }
}
