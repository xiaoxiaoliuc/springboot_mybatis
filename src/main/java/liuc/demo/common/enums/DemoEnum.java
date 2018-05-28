package liuc.demo.common.enums;

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
 * @Date 2018/5/24 22:01
 * @see
 */
public enum DemoEnum implements IEnum {
    DEMO_ENUM(0, "这是demo"),
    SUCCESS(1,"成功"),
    ERORR(2,"失败");
    private String msg;
    private Integer code;

    DemoEnum(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
