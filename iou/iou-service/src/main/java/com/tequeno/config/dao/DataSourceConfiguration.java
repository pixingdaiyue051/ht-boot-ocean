package com.tequeno.config.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.tequeno.iou.mapper")
public class DataSourceConfiguration {
    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.initialSize}")
    private int initialSize;

    @Value("${jdbc.minIdle}")
    private int minIdle;

    @Value("${jdbc.maxActive}")
    private int maxActive;

    @Value("${jdbc.maxWait}")
    private int maxWait;

    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

//    @Value("${jdbc.validationQuery}")
//    private String validationQuery;
//
//    @Value("${jdbc.testWhileIdle}")
//    private boolean testWhileIdle;
//
//    @Value("${jdbc.testOnBorrow}")
//    private boolean testOnBorrow;
//
//    @Value("${jdbc.testOnReturn}")
//    private boolean testOnReturn;
//
//    @Value("${jdbc.poolPreparedStatements}")
//    private boolean poolPreparedStatements;
//
//    @Value("${jdbc.maxPoolPreparedStatementPerConnectionSize}")
//    private int maxPoolPreparedStatementPerConnectionSize;
//
//    @Value("${jdbc.filters}")
//    private String filters;
//
//    @Value("{jdbc.connectionProperties}")
//    private String connectionProperties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setValidationQuery(validationQuery);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        try {
//            datasource.setFilters(filters);
//        } catch (SQLException e) {
//            logger.log(Level.ERROR, "druid configuration initialization filter : {0}", e);
//        }
//        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }

//    @Bean
//    public DataSourceTransactionManager dataSourceTransactionManager() {
//        DataSourceTransactionManager manager = new DataSourceTransactionManager();
//        manager.setDataSource(dataSource());
//        return manager;
//    }
//
//    @Bean
//    public TransactionTemplate transactionTemplate() {
//        TransactionTemplate template = new TransactionTemplate();
//        template.setTransactionManager(dataSourceTransactionManager());
//        return template;
//    }
}