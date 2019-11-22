package edu.xpu.journey.service;

import edu.xpu.journey.entity.ArticleInfo;
import java.util.List;

public interface ArticleService {
    List<ArticleInfo> getPageArticleList(Integer status, Integer page, Integer pageSize);
}
