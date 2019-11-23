package edu.xpu.journey.service;

import edu.xpu.journey.entity.ArticleInfo;
import java.util.List;

public interface ArticleService {

    /**
     * 根据文章状态进行分页查询
     * @param status （0、草稿 1、已发布 2、已删除）
     * @param page 页面（从0开始）
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<ArticleInfo> getPageArticleList(Integer status, Integer page, Integer pageSize);

    /**
     * 把文章移入回收站
     * @param articleId 文章编号
     */
    void articleToRecycle(Integer articleId);

    /**
     * 根据文章编号获取文章具体内容
     * @param articleId 文章的编号
     * @return 文章对象
     */
    ArticleInfo getArticleById(Integer articleId);
}
