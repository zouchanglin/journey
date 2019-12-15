package edu.xpu.journey.service;

import edu.xpu.journey.vo.SideBarVO;

/**
 * 用来统计各种信息的接口
 * @author 长林
 */
public interface CountService {

    /**
     * 统计总文章篇数
     * @return 总文章篇数
     */
    int getArticleCount();

    /**
     * 根据状态（发布、已删除、草稿）统计文章篇数
     * @param articleStatus 文章状态
     * @return 文章篇数
     */
    int getArticleCountByStatus(Integer articleStatus);

    /**
     * 阅读量统计(只统计发布的文章)
     * @return 阅读量
     */
    long getReadingCount();

    /**
     * 点赞统计 (只统计发布的文章)
     * @return 点赞量
     */
    int getLoveCount();

    /**
     * 评论量统计
     * @return 评论量
     */
    int getDiscussCount();


    /**
     * 获取侧边栏的打包数据
     * @return 数据包
     */
    SideBarVO getCountDataPackage();
}