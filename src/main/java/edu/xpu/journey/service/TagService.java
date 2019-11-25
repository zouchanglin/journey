package edu.xpu.journey.service;

import edu.xpu.journey.entity.TagInfo;

import java.util.List;

public interface TagService {
    /**
     * 查找一篇文章的所有标签
     * @param article 文章编号
     * @return 标签集合
     */
    List<TagInfo> getArticleTag(Integer article);

    List<TagInfo> getAllTags();

    List<TagInfo> getOtherTags(Integer article);
}
