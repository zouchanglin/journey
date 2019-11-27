package edu.xpu.journey.controller.show;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 长林
 */
@Controller
@RequestMapping("/")
public class ShowIndexController {
    @GetMapping
    public String getIndex(){
        return "view/index";
    }
}
