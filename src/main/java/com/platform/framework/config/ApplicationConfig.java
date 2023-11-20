package com.platform.framework.config;

import com.platform.framework.aspectj.mybatis.QueryInterceptor;
import com.platform.framework.aspectj.mybatis.UpdateInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.TimeZone;

/**
 * 程序注解配置
 *
 */
@Configuration
// 表示通过aop框架暴露该代理对象,AopContext能够访问
@EnableAspectJAutoProxy(exposeProxy = true)
// 指定要扫描的Mapper类的包的路径
@MapperScan("com.platform.project.**.mapper")
public class ApplicationConfig
{
    /**
     * 时区配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization()
    {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }

    /**
     * 数据查询过滤器
     */
    @Bean
    public QueryInterceptor queryInterceptor() {
        QueryInterceptor query =  new QueryInterceptor();
        query.setLimit(-1L);
        return query;
    }

    /**
     * 插入数据过滤器
     */
    @Bean
    public UpdateInterceptor updateInterceptor() {
        return new UpdateInterceptor();
    }

}
