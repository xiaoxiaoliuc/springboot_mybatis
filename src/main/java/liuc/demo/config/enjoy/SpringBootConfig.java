package liuc.demo.config.enjoy;

import com.jfinal.template.ext.spring.JFinalViewResolver;
import com.jfinal.template.source.ClassPathSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuc QQ 2379817864
 * @Date 2018/5/21 21:15
 * @see
 */
@Configuration
public class SpringBootConfig {
    @Bean(name = "jFinalViewResolver")
    public JFinalViewResolver getJFinalViewResolver() {
        JFinalViewResolver jfr = new JFinalViewResolver();
        jfr.setDevMode(true);
        jfr.setSourceFactory(new ClassPathSourceFactory());
        jfr.setPrefix("/templates/");
        jfr.setSuffix(".html");
        jfr.setContentType("text/html;charset=UTF-8");
        jfr.setOrder(0);
        return jfr;
    }
}

