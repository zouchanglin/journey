package edu.xpu.journey.controller.admin;

import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.form.CategoryForm;
import edu.xpu.journey.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author x
 */
@Controller
@Slf4j
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") Integer categoryId,
                                 Map<String, Object> map){
        if(categoryId == null){
            map.put("msg", "请保持参数完整性 ");
            map.put("url", "/admin/category/list");
            return "/admin/common/error";
        }
        categoryService.deleteOne(categoryId);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/list")
    public String list(Map<String, Object> map){
        List<CategoryInfo> list = categoryService.getAll();
        map.put("list", list);
        return "admin/category/list";
    }


    @RequestMapping("/new")
    public String newCategory(@RequestParam("categoryName") String categoryName,
                              @RequestParam("categoryDec") String categoryDec,
                              Map<String, Object> map){
        if(TextUtils.isEmpty(categoryName)){
            map.put("msg", "请保持参数完整性 ");
            map.put("url", "/admin/category/list");
            return "/admin/common/error";
        }
        CategoryInfo saveResult = categoryService.addNewOne(categoryName, categoryDec);
        log.info("[CategoryController] newCategory() saveResult={}", saveResult);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/update")
    public String updateCategory(CategoryForm categoryForm,
                                 Map<String, Object> map){
        categoryService.updateCategory(categoryForm);
        map.put("url", "/admin/category/list");
        map.put("msg", "修改成功");
        return "/admin/common/success";
    }

    @RequestMapping("/view/update/{categoryId}")
    public String getUpdateView(@PathVariable("categoryId") Integer categoryId,
                                Map<String, Object> map){
        CategoryInfo categoryInfo = categoryService.getOneById(categoryId);
        map.put("categoryInfo", categoryInfo);
        return "/admin/category/update";
    }
}