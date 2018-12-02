package com.changsheng.core.db;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages  = "com.changsheng.love.dao.pg", sqlSessionTemplateRef  = "pgSqlSessionTemplate")
public class DataSourcePgConfig {

    @Bean(name = "pgDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.pg")
    public DataSource pgDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pgSqlSessionFactory")
    public SqlSessionFactory pgSqlSessionFactory(@Qualifier("pgDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/pg/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "pgTransactionManager")
    public DataSourceTransactionManager pgTransactionManager(@Qualifier("pgDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "pgSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("pgSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
