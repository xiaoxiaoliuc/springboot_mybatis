package liuc.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuc
 * @since 2018-05-24
 */
@Data
public class Demo1 extends Model<Demo1> {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("roleId")
    @NotNull(message = "不能为空")
    private String roleId;
    @NotBlank(message = "aaa")
    private String a;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
