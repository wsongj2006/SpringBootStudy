package com.andy.spb.configuration;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author wusongjiang
 * @Description
 * @Date 2018-04-08 21:43
 */

@Configuration
@MapperScan(basePackages = "com.andy.spb.dao")
public class MyBatisConfig {

    @Autowired
    private Environment env;

    /**
     * 第一个数据源
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource wsjDataSource() throws Exception {
        Properties properties = new Properties();
        properties.put("driverClassName", env.getProperty("spring.datasource.1.driverClassName"));
        properties.put("url", env.getProperty("spring.datasource.1.url"));
        properties.put("username", env.getProperty("spring.datasource.1.username"));
        properties.put("password", env.getProperty("spring.datasource.1.password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    /**
     * 第二个数据源
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource db2DataSource() throws Exception {
        Properties properties = new Properties();
        properties.put("driverClassName", env.getProperty("spring.datasource.2.driverClassName"));
        properties.put("url", env.getProperty("spring.datasource.2.url"));
        properties.put("username", env.getProperty("spring.datasource.2.username"));
        properties.put("password", env.getProperty("spring.datasource.2.password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }


    /**
     * 指定数据源
     * @param ds
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db2DataSource") DataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);
        return fb.getObject();
    }

    /**
     * 指定数据源
     * @param
     * @return
     * @throws Exception
     */
    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}
