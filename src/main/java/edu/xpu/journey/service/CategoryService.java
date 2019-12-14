package edu.xpu.journey.service;

import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.form.CategoryForm;

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

    /**
     * 删除一个分类
     * @param categoryId 分类编号
     */
    void deleteOne(Integer categoryId);


    /**
     * 查找分类信息
     * @param categoryId 分类编号
     * @return 查找结果
     */
    CategoryInfo getOneById(Integer categoryId);

    /**
     * 更新分类信息
     * @param categoryForm 分类信息表单
     */
    void updateCategory(CategoryForm categoryForm);
}
