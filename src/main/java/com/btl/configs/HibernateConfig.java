/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

/**
 *
 * @author Admin
 */
@Configuration
@PropertySource("classpath:databases.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setPackagesToScan("com.btl.pojos");
        factory.setDataSource(dataSource());
        factory.setHibernateProperties(hibernateProperties());

        return factory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
        d.setUrl(env.getProperty("hibernate.connection.url"));
        d.setUsername(env.getProperty("hibernate.connection.username"));
        d.setPassword(env.getProperty("hibernate.connection.password"));

        return d;
    }

    public Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty(SHOW_SQL, env.getProperty("hibernate.showSql"));
        props.setProperty(DIALECT, env.getProperty("hibernate.dialect"));

        return props;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager h = new HibernateTransactionManager();

        h.setSessionFactory(getSessionFactory().getObject());

        return h;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dtyhpio9g",
                "api_key", "188733333893467",
                "api_secret", "wZYQmVOC1hOdrW_AVi14TQ305MA",
                "secure", true
        ));
        return c;
    }
}
