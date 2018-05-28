package liuc.demo.controller;


import liuc.demo.common.annotation.Log;
import liuc.demo.common.json.Result;
import liuc.demo.entity.Demo1;
import liuc.demo.service.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuc
 * @since 2018-05-24
 */
@Controller
@RequestMapping("/demo1")
public class Demo1Controller {
    @Autowired
    private Demo1Service demo1Service;
    @RequestMapping("/say")
    @Log(value = "这是测试 ")
    public String say(@Valid Demo1 demo1, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return defaultMessage;
        }
        List<Demo1> demo1s = demo1Service.selectList(null);
        model.addAttribute("a",demo1s);
        model.addAttribute("aa","Hello Hot");
        System.out.println(demo1);
        return "demo";
    }
    @RequestMapping("/say1")
    @ResponseBody
    public Result say1(Model model,Integer id){
        Result byId = demo1Service.findById(id);
        return byId;
    }
}

