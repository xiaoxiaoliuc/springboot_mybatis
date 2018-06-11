package liuc.demo;

import cn.hutool.core.lang.Singleton;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import liuc.demo.config.redis.MyRedisConfig;
import liuc.demo.entity.Demo1;
import liuc.demo.mapper.Demo1Mapper;
import liuc.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private Demo1Mapper demo1Mapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisTemplate<Object, Demo1> demo1RedisTemplate;
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Test
    public void contextLoad() {
        Demo1 demo1 = new Demo1();
        demo1.setA("A");
        demo1.setRoleId("我是roleId");

        rabbitTemplate.convertAndSend("rabbit1.exchange","demo1.news",demo1);
//        Object o = rabbitTemplate.receiveAndConvert("aa.news");
//        System.out.println(o);
    }
    @Test
    public void contextLoad2() {
//        Exchange exchange = new DirectExchange("rabbit1.exchange");
//        amqpAdmin.declareExchange(exchange);

//        amqpAdmin.declareQueue(new Queue("demo1.news"));
        amqpAdmin.declareBinding(new Binding("demo1.news",Binding.DestinationType.QUEUE,"rabbit1.exchange","demo1.news",null));
    }
    @Test
    public void redisTest() {
//        stringRedisTemplate.opsForValue().append("msg","Hello World");
        Demo1 demo1 = demo1Mapper.selectById(1);
        demo1RedisTemplate.opsForValue().set(1, demo1);
//        Object demo11 = demo1RedisTemplate.opsForValue().get("demo11");
//        System.out.println(demo11);
    }


    @Test
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("周星星");
        message.setText("今晚 打老虎");
        message.setTo("17778045265@163.com");
        message.setFrom("17611629770@163.com");
        mailSender.send(message);
    }

    @Test
    public void sendEmail2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("周星星");
        helper.setText("<h1 style='color: red'>今晚 打老虎</h1>", true);
        helper.setTo("17778045265@163.com");
        helper.setFrom("17611629770@163.com");
        mailSender.send(mimeMessage);
    }

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
