package liuc.demo.common.utils;

import liuc.demo.common.enums.DemoEnum;
import liuc.demo.common.enums.IEnum;
import liuc.demo.common.json.Result;

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
 * @Date 2018/5/24 22:09
 * @see
 */
public class ResultUtil {
    public static Result success(Object o, IEnum iEnum){
        Result result = new Result();
        result.setCode(iEnum.getCode());
        result.setMsg(iEnum.getMsg());
        result.setData(o);
        return result;
    }
    public static Result success(){
        return success(null,DemoEnum.SUCCESS);
    }
    public static Result success(Object o){
        return success(o,DemoEnum.SUCCESS);
    }
    public static Result error(IEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

