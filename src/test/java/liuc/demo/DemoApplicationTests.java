package liuc.demo;

import cn.hutool.core.lang.Singleton;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import liuc.demo.entity.Demo1;
import liuc.demo.mapper.Demo1Mapper;
import liuc.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private Demo1Mapper demo1Mapper;

    @Test
    public void contextLoads() {
//        Demo1 demo1 = Singleton.get(Demo1.class);
//        Demo1 demo11 = Singleton.get(Demo1.class);
//        logger.info("demo1 == demo11 : {}", demo1 == demo11);
//        DemoService demoService = (s) -> System.out.println(s);
//        Demo1 demo12 = new Demo1();
//        demo12.setA(" 恩 哼 ");
//        Optional<Demo1> optionalDemo1 = Optional.of(demo12);
//        demoService.say(optionalDemo1.orElse(new Demo1()));
//
//
//        List<String> al = Arrays.asList("a", "b", "c", null);
//        //java8 逻辑
//        Consumer<String> consumer = DemoApplicationTests::say;
//        al.forEach(x -> consumer.accept(x));
//        al.forEach(DemoApplicationTests::say);
//        //原来逻辑
//        for (String s : al) {
//            if (s == null) {
//                s = "默认值";
//            }
//            System.out.println(s);
//        }
//        List<String> list = new ArrayList<String>();
//        list.add("aa");
//        list.add("bb");
//        list.add("cc");
//        list.add("ac");
//        list.add("ad");
//        list.stream().filter(x->x.startsWith("a")).peek(s -> System.out.println(s)).filter(s -> s.endsWith("d")).forEach(System.out::println);
//        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
//        System.out.println(minValue);
        System.out.println(ForkJoinPool.commonPool().getParallelism());
    }

    private static void say(String s) {
        System.out.println(s);
    }

    @Test
    public void contextLoads1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> submit = executorService.submit(() -> {
            return "Hello World";
        });
        System.out.println(submit.get());
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
        logger.info("resut2  {}", result2);
    }
}
