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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages  = "com.changsheng.love.dao.sqlite", sqlSessionTemplateRef  = "sqliteSqlSessionTemplate")
public class DataSourceSqliteConfig {

    @Bean(name = "sqliteDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sqlite")
    @Primary
    public DataSource sqliteDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqliteSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqliteSqlSessionFactory(@Qualifier("sqliteDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/sqlite/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "sqliteTransactionManager")
    @Primary
    public DataSourceTransactionManager sqliteTransactionManager(@Qualifier("sqliteDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqliteSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqliteSqlSessionTemplate(@Qualifier("sqliteSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
