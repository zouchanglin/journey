package edu.xpu.journey.service;

import edu.xpu.journey.entity.CategoryInfo;

import java.util.List;

/**
 * @author x
 */
public interface CategoryService {
    /**
     * 获取所有分类
     * @return 所有的分类列表
     */
    List<CategoryInfo> getAll();

    /**
     * 新增分类信息
     * @param categoryName 分类名称
     * @param categoryDec 分类描述信息
     * @return 新增结果
     */
    CategoryInfo addNewOne(String categoryName, String categoryDec);
}
