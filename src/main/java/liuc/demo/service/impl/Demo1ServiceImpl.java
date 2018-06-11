package liuc.demo.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import liuc.demo.common.enums.DemoEnum;
import liuc.demo.common.json.Result;
import liuc.demo.common.utils.ResultUtil;
import liuc.demo.entity.Demo1;
import liuc.demo.exception.DemoException;
import liuc.demo.mapper.Demo1Mapper;
import liuc.demo.service.Demo1Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuc
 * @since 2018-05-24
 */
@Service
public class Demo1ServiceImpl extends ServiceImpl<Demo1Mapper, Demo1> implements Demo1Service {
    @Autowired
    private Demo1Mapper demo1Mapper;

    @Override
    @Cacheable(value = "findById" ,key = "'demo1_'+#id")
    public Result<Demo1> findById(Integer id) {
        if (id == 1) throw new DemoException(DemoEnum.DEMO_ENUM);

        Demo1 demo1 = demo1Mapper.selectById(2);
        System.out.println("没有走缓存");
        return ResultUtil.success(demo1);
    }
    @CacheEvict(value = "findById",key = "'demo1_'+#id")
    public Result deleteById(Integer id){
        if (id == 1) throw new DemoException(DemoEnum.DEMO_ENUM);

        Integer integer = demo1Mapper.deleteById(2);
        System.out.println("没有走缓存");
        return ResultUtil.success(integer);
    }
    @RabbitListener(queues = "demo1.news")
    public void receive(Demo1 demo1){
        System.out.println("收到消息");
        System.out.println(demo1);
    }
}
