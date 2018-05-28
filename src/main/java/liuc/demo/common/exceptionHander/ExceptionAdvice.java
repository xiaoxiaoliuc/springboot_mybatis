package liuc.demo.common.exceptionHander;

import liuc.demo.common.json.Result;
import liuc.demo.common.utils.ResultUtil;
import liuc.demo.exception.DemoException;
import liuc.demo.exception.SuperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author liuc QQ 2379817864
 * @Date 2018/5/24 22:03
 * @see
 */
@ControllerAdvice
public class ExceptionAdvice {
    public static final Logger loger = LoggerFactory.getLogger(ExceptionAdvice.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof SuperException){
            SuperException demoException = (SuperException) e;
            return ResultUtil.error(demoException.getCode(),demoException.getMessage());
        }else {
            loger.info("e={}",e.getMessage());
            return ResultUtil.error(-1,"未知错误");
        }
    }

}

