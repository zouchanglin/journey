package edu.xpu.journey.service.impl;

import edu.xpu.journey.dao.CategoryInfoRepository;
import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.form.CategoryForm;
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
    @Autowired
    private CategoryInfoRepository categoryRepository;
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

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

    @Override
    public void subCountOne(Integer category) {
        Optional<CategoryInfo> categoryInfo = categoryRepository.findById(category);
        if(categoryInfo.isPresent()){
            CategoryInfo info = categoryInfo.get();
            info.setAmount(info.getAmount() - 1);
            categoryRepository.save(info);
        }
    }

    @Override
    public void addCountOne(Integer category) {
        Optional<CategoryInfo> categoryInfo = categoryRepository.findById(category);
        if(categoryInfo.isPresent()){
            CategoryInfo info = categoryInfo.get();
            info.setAmount(info.getAmount() + 1);
            categoryRepository.save(info);
        }
    }

    @Override
    public Integer flushArticleCount(Integer category) {
        Integer newCountValue = articleInfoMapper.countArticleByStatusAndCategory(ArticleStatusEnum.RELEASE.getCode(), category);
        Optional<CategoryInfo> findResultOpt = categoryRepository.findById(category);
        if(findResultOpt.isPresent()){
            CategoryInfo categoryInfo = findResultOpt.get();
            categoryInfo.setAmount(newCountValue);
            categoryRepository.save(categoryInfo);
        }
        return newCountValue;
    }
}