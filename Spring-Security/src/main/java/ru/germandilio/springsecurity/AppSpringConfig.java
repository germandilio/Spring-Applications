package ru.germandilio.springsecurity;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.germandilio.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppSpringConfig {
    private static final Logger logger = Logger.getLogger(AppSpringConfig.class.getName());

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ViewResolver jspViewResolver() {
        return new InternalResourceViewResolver("/www/", ".jsp");
    }

    @Bean
    public DataSource securityDataSource() {
        var securityDataSource = new ComboPooledDataSource();

        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
            logger.info("jdbc:url=" + environment.getProperty("jdbc.url"));
            logger.info("jdbc:user=" + environment.getProperty("jdbc.user"));
        } catch (PropertyVetoException ex) {
            throw new RuntimeException(ex);
        }

        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    private int getIntProperty(String propertyName) {
        var property = environment.getProperty(propertyName);
        assert property != null;
        return Integer.parseInt(property);
    }
}
