package edu.xpu.journey.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author 长林
 */
@Controller
@RequestMapping("/admin/center")
public class IndexController {
    /**
     * 后台管理首页
     * @return 后台管理中心的页面
     */
    @GetMapping
    public String center(){
        return "admin/centerShow";
    }
}