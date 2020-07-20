package ecare.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    static final Logger logger = LoggerFactory.getLogger(MvcWebApplicationInitializer.class);



    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("Getting RootConfigClasses Initialization");
        return new Class[]{DataConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("Getting ServletConfigClasses Initialization");
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        logger.info("Getting ServletMappings Initialization");
        return new String[]{"/"};
    }
}
