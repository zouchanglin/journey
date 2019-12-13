package edu.xpu.journey.service.impl;

import edu.xpu.journey.dao.CategoryInfoRepository;
import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author x
 * @since 2019.12.14
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryInfoRepository categoryRepository;

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
}
