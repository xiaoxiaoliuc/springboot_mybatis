package liuc.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel("Demo信息")
public class Demo1 extends Model<Demo1> implements Serializable{
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id主键")
    private Integer id;
    @TableField("roleId")
    @NotNull(message = "不能为空")
    @ApiModelProperty(value = "角色id")
    private String roleId;
    @NotBlank(message = "aaa")
    @ApiModelProperty(value = "额 A")
    private String a;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
