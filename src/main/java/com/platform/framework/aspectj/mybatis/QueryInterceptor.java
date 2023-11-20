package com.platform.framework.aspectj.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * 查询拦截器，用于拦截处理通用的信息、如用户ID、多租户信息等；
 * 特别注意：此处继承了PaginationInterceptor分页，分页必须在拦截数据后执行，否则容易出现分页不准确，分页计数大于实际数量等问题
 * @author bool
 */
@Log4j2
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}),})
public class QueryInterceptor extends PaginationInterceptor implements Interceptor {

    /**
     * 客户ID
     */
    private static final String USER_FILTER = "{{userId}}";



    @Override
    public Object intercept(Invocation invocation) throws Throwable {


        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

        //sql语句类型
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        // 只过滤查询的
        if (SqlCommandType.SELECT == sqlCommandType) {
            // 获得原始SQL
            String sql = statementHandler.getBoundSql().getSql();

            // 不处理
            if(!sql.contains(USER_FILTER)){
                return super.intercept(invocation);
            }
            // 处理SQL语句
            String outSql = this.parseSql(sql);
            // 设置SQL
            metaObject.setValue("delegate.boundSql.sql", outSql);
            // 再分页
            return super.intercept(invocation);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }



    /**
     * 处理注入用户信息
     * @param src
     * @return
     */
    private String parseSql(String src) {

        return src;
    }


}
