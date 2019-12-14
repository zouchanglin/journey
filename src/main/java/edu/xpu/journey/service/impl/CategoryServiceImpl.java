package edu.xpu.journey.service.impl;

import edu.xpu.journey.dao.CategoryInfoRepository;
import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.form.CategoryForm;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author x
 * @since 2019.12.14
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryInfoRepository categoryRepository;
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    public CategoryServiceImpl(CategoryInfoRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryInfo addNewOne(String categoryName, String categoryDec) {
        return categoryRepository.save(new CategoryInfo().
                setMyname(categoryName).setDescribes(categoryDec).setAmount(0));
    }

    @Override
    public List<CategoryInfo> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteOne(Integer categoryId) {
        articleInfoMapper.changeCategoryToDefault(categoryId);
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryInfo getOneById(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElse(new CategoryInfo());
    }

    @Override
    public void updateCategory(CategoryForm categoryForm) {
        Optional<CategoryInfo> findResult = categoryRepository.findById(categoryForm.getId());
        if(findResult.isPresent()){
            CategoryInfo findCategoryInfo = findResult.get();
            findCategoryInfo.setMyname(categoryForm.getMyname());
            findCategoryInfo.setDescribes(categoryForm.getDescribes());
            categoryRepository.save(findCategoryInfo);
        }
    }
}