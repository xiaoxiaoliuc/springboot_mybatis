package liuc.demo.common.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
 * @Date 2018/5/31 21:03
 * @see
 */
@Component
public class SpringTaskDemo {
    private static final Logger logger = LoggerFactory.getLogger(SpringTaskDemo.class);
    @Async
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() throws InterruptedException {
        Thread.sleep(3000);
//        System.out.println(111111);
        logger.info("scheduled 每秒执行一次： {}",LocalDateTime.now()) ;
    }
    @Scheduled(fixedRate = 1000)
    public void scheduled2() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("scheduled2 每1秒执行一次：{}", LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduled3() throws InterruptedException {
        Thread.sleep(5000);
        logger.info("scheduled3 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
    }

}

