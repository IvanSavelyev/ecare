package ecare.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ecare")
@EnableTransactionManagement
@PropertySource(value = "classpath:app.properties")
public class DataConfig {

    static final Logger logger = LoggerFactory.getLogger(DataConfig.class);

    private Environment environment;
    @Autowired
    public DataConfig(Environment environment) {
        logger.info("Creation DataConfig constructor");
        this.environment = environment;
    }

    private Properties properties(){
        logger.info("Creation HIBERNATE properties");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }

    public DataSource dataSource(){
        logger.info("Configuration DATASOURCE");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbs.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbs.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbs.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbs.password"));
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        logger.info("Configuration LocalSessionFactoryBean");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("ecare.domain");
        sessionFactoryBean.setHibernateProperties(properties());
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        logger.info("Configuration HibernateTransactionManager");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return transactionManager;
    }
}
