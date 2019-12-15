package edu.xpu.journey.vo;

import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.entity.TagInfo;
import lombok.Data;

import java.util.List;

/**
 * @author x
 */
@Data
public class SideBarVO {
    /**
     * 博客标题
     */
    private String blogTitle;

    /**
     * 博客副标题
     */
    private String blogSubtitle;

    /**
     * 文章统计
     */
    private Integer articleCount;

    /**
     * 评论统计
     */
    private Integer discussCount;
    /**
     * 点赞数量
     */
    private Integer loveCount;

    /**
     * 阅读数量
     */
    private Long readingCount;

    /**
     * 标签列表
     */
    private List<TagInfo> tagInfoList;

    /**
     * 分类列表
     */
    private List<CategoryInfo> categoryInfoList;
}