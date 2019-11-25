package edu.xpu.journey.service;

import edu.xpu.journey.entity.TagInfo;

import java.util.List;

/**
 * @author 长林
 */
public interface TagService {
    /**
     * 查找一篇文章的所有标签
     * @param article 文章编号
     * @return 标签集合
     */
    List<TagInfo> getArticleTag(Integer article);

    /**
     * 获取所有的标签
     * @return 标签列表
     */
    List<TagInfo> getAllTags();

    /**
     * 获取除了一篇文章的标签的其他标签
     * @param article 文章编号
     * @return 标签集合
     */
    List<TagInfo> getOtherTags(Integer article);
}
