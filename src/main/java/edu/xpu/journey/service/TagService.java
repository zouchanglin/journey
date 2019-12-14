package edu.xpu.journey.service;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.TagInfo;

import java.util.List;

/**
 * @author 长林
 */
public interface TagService {
    /**
     * 根据标签获取此标签下的已发布文章
     * @param tag 标签ID
     * @return 文章集合
     */
    List<ArticleInfo> getAllArticleForTag(Integer tag);

    /**
     * 查找一篇文章的所有标签
     * @param article 文章编号
     * @return 标签信息集合
     */
    List<TagInfo> getArticleTag(Integer article);

    /**
     * 获取所有的标签信息
     * @return 标签信息集合
     */
    List<TagInfo> getAllTags();

    /**
     * 获取除了一篇文章的标签的其他标签
     * @param article 文章编号
     * @return 标签集合
     */
    List<TagInfo> getOtherTags(Integer article);

    /**
     * 对一篇文章设置标签信息
     * @param article 文章编号
     * @param tags 标签用ID集合的字符串表示
     */
    void setTagsForArticle(Integer article, String tags);

    /**
     * 新增标签信息
     * @param tagName 标签名称
     */
    void addNewTag(String tagName);

    /**
     * 更新标签信息
     * @param tagId 标签ID
     * @param tagName 标签名称
     */
    void updateTag(Integer tagId, String tagName);

    /**
     * 删除标签信息
     * @param tagId 标签ID
     */
    void deleteTagById(Integer tagId);
}
