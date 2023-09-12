package com.coop.tripleunionhospitalregistrationsystemservice.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.coop.tripleunionhospitalregistrationsystemservice.util.EasySqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.coop.tripleunionhospitalregistrationsystemservice.service.*.mapper*")
public class MybatisPlusConfig {
    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Primary
    @Bean
    public EasySqlInjector easySqlInjector () {
        return new EasySqlInjector();
    }

    /**
     * 自定义批量插入 SQL 注入器
     */
    @Bean
    public InsertBatchSqlInjector insertBatchSqlInjector() {
        return new InsertBatchSqlInjector();
    }

}
