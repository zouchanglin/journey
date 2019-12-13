package edu.xpu.journey.controller.admin;

import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author x
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map){
        List<CategoryInfo> list = categoryService.getAll();
        map.put("list", list);
        return "admin/category/list";
    }


    @PostMapping("/new")
    public String newCategory(@RequestParam("categoryName") String categoryName,
                              @RequestParam("categoryDec") String categoryDec){
        CategoryInfo saveResult = categoryService.addNewOne(categoryName, categoryDec);
        return "";
    }
}