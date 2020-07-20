package ecare.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("ecare")
public class SpringMvcConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;
    private static final Logger logger = LoggerFactory.getLogger(SpringMvcConfig.class);

    @Autowired
    public SpringMvcConfig(ApplicationContext applicationContext) {
        logger.info("SpringMvcConfig Constructor creating");
        this.applicationContext = applicationContext;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        logger.info("DefaultServletHandling configuration");
        configurer.enable();
    }
    
    @Bean
    public InternalResourceViewResolver getViewResolver(){
        logger.info("ViewResolver Configuration");
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setApplicationContext(applicationContext);
        resourceViewResolver.setViewClass(JstlView.class);
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        return resourceViewResolver;
    }

}
