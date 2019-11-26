package edu.xpu.journey.service;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.form.ArticleFrom;

import java.util.List;

/**
 * @author 长林
 */
public interface ArticleService {

    /**
     * 发布一篇文章
     * @param article 文章编号（如果是新文章则传此参数为 0）
     * @param articleFrom 文章内容
     * @return 发布成功
     */
    ArticleInfo releaseArticle(Integer article, ArticleFrom articleFrom);

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

    /**
     * 根据文章状态查询文章数目
     * @param status 文章状态
     * @return 文章数目
     */
    Integer getArticleCountByStatus(Integer status);
}
