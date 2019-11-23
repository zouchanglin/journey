package edu.xpu.journey.service.impl;

import edu.xpu.journey.dao.CategoryInfoRepository;
import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryInfoRepository categoryRepository;
    @Override
    public List<CategoryInfo> getAll() {
        return categoryRepository.findAll();
    }
}
