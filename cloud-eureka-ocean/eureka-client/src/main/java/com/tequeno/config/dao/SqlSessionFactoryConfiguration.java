package com.tequeno.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SqlSessionFactoryConfiguration {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Value("${mybatisConfigLocation}")
    private String mybatisConfigLocation;
    @Value("${mapperLocation}")
    private String mapperLocation;
    @Value("${entityLocation}")
    private String entityLocation;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 加载mybatis-config.xml
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigLocation));
        // 读取mapper路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperLocation));
        // 读取entity路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityLocation);
        return sqlSessionFactoryBean;
    }
}
