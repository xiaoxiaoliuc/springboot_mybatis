package liuc.demo.service;


import com.baomidou.mybatisplus.service.IService;
import liuc.demo.common.json.Result;
import liuc.demo.entity.Demo1;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuc
 * @since 2018-05-24
 */
public interface Demo1Service extends IService<Demo1> {
    Result<Demo1> findById(Integer id);
    Result deleteById(Integer id);
}
