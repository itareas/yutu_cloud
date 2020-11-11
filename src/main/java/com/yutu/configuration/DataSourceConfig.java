package com.yutu.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName: DataSourceMySql
 * @Author: zhaobc
 * @Date: 2019/5/19 19:57
 * @Description: MySql多数据源配置      @Primary为主数据库
 **/
@Configuration
@MapperScan(basePackages = "com.yutu.mapper.frame", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

    @Value("${spring.datasource.frame.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.frame.url}")
    private String url;

    @Value("${spring.datasource.frame.username}")
    private String username;

    @Value("${spring.datasource.frame.password}")
    private String password;

    //其他配置
    @Value("${spring.datasource.frame.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.frame.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.frame.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.frame.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.frame.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.frame.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:18
     * @Description: 数据源配置加载配置文件
     **/
    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        //其他配置
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);

        return dataSource;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:19
     * @Description: 创建该数据源的连接数据库工厂
     **/
    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/yutu/mapper/frame/**/*.xml"));
        return bean.getObject();
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:21
     * @Description: 该数据源事务控制  用法 @Transactional(transactionManager="mySqlTransactionManager")
     **/
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:25
     * @Description: MyBatis提供的持久层访问模板化的工具，线程安全，可通过构造参数或依赖注入SqlSessionFactory实例
     **/
    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
