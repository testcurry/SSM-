package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * springmvc在方法上传入原生的request和session外还能怎么样把数据传给页面？
 * 方法上传入map，model和modelMap实际上传的都是这个类型的参数：
 * class org.springframework.validation.support.BindingAwareModelMap
 * modelAndView
 * 这四种类型，数据都是保存在request域中的
 *
 * 保存在session域中；
 * 推荐使用原生API，@SessionAttributes可能会引发异常
 */

@Controller
public class OutputController {

    @RequestMapping(value = "/handle01")
    public String handle01(Map<String, Object> map) {
        map.put("msg", "你好！");
        System.out.println("handle01...");
        System.out.println(map.getClass());
        return "success";
    }

    @RequestMapping(value = "/handle02")
    public String handle02(Model model) {
        model.addAttribute("msg", "你好可爱！");
        System.out.println("handle02...");
        System.out.println(model.getClass());
        return "success";
    }

    @RequestMapping(value = "/handle03")
    public String handle03(ModelMap modelMap) {
        modelMap.addAttribute("msg", "你好棒！");
        System.out.println("handle03...");
        System.out.println(modelMap.getClass());
        return "success";
    }

    @RequestMapping(value = "/handle04")
    public ModelAndView modelAndView() {
//        ModelAndView mv = new ModelAndView("success");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("msg", "你好温柔！");
        return mv;
    }
}
