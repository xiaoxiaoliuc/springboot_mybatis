package liuc.demo.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import liuc.demo.entity.Demo1;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuc
 * @since 2018-05-24
 */
public interface Demo1Mapper extends BaseMapper<Demo1> {
     List<Demo1> find() ;
}
