package liuc.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liuc.demo.common.annotation.Log;
import liuc.demo.common.json.Result;
import liuc.demo.common.utils.ResultUtil;
import liuc.demo.entity.Demo1;
import liuc.demo.service.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuc
 * @since 2018-05-24
 */
@Controller
@Api(tags = "demo管理")
@RequestMapping("/demo1")
public class Demo1Controller {
    @Autowired
    private Demo1Service demo1Service;
    @GetMapping("/say")
    @ApiOperation("测试。。。")
    @Log(value = "这是测试 ")
    public String say( @Valid Demo1 demo1, BindingResult bindingResult, Model model){
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
    @GetMapping("/say4")
    public String say4( Model model){

        return "index";
    }
    @GetMapping("/say1")
    @ApiOperation("测试1.。。")
    @ResponseBody
    public Result say1(Model model,Integer id){
        Map<String,List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("demoA");
        list.add("demoB");
        map.put("demo",list);
        return ResultUtil.success(map);
    }
    @GetMapping("/say2")
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ResponseBody
    public Result<Demo1> say2(@ApiParam("主键id") Integer id){
        Result byId = demo1Service.findById(id);
        System.out.println(byId.getCode());
        System.out.println(byId.getMsg());
        System.out.println(byId.getData());
        return byId;
    }
    @GetMapping("/say3")
    @ApiOperation(value="删除demo1信息", notes="根据url的id来获取用户详细信息")
    @ResponseBody
    public Result say3(@ApiParam("主键id") Integer id){
        Result result = demo1Service.deleteById(id);
        return result;
    }
}

