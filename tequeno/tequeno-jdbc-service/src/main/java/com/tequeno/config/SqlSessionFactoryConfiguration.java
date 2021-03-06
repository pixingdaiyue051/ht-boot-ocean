package com.tequeno.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SqlSessionFactoryConfiguration {
    @Resource
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Value("${mapper.mapperLocation}")
    private String mapperLocation;
    @Value("${mapper.entityLocation}")
    private String entityLocation;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 读取mapper路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocation));
        // 读取entity路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityLocation);
        return sqlSessionFactoryBean;
    }
}
