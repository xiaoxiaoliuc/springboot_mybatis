package liuc.demo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import liuc.demo.entity.Demo1;
import liuc.demo.mapper.Demo1Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private Demo1Mapper demo1Mapper;

    @Test
    public void contextLoads() {
        Demo1 demo1 = new Demo1();
        demo1.setA("aa");
        demo1.insert();
    }

    private final static Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<>();
        map.put("测试", 1);
        map.put("ceshi", 2);
        String result = Joiner.on(",").withKeyValueSeparator("=").join(map);
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        String result1 = Joiner.on("-").join(list);
        logger.info("result={}", result);
        logger.info("result1={}", result1);

        // 判断匹配结果
        boolean result2 = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).matches('1'); //true
        logger.info("resut2  {}",result2);
    }
}
