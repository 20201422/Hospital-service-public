package com.coop.tripleunionhospitalregistrationsystemservice.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {  // http://localhost:9090/druid/login.html
    
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
    
    //sql后台监控:web.xml
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        
        //账号密码配置
        Map<String, String> initParams = new HashMap<>();
        initParams.put("allow", "");    //允许任何人访问 localhost-只能本机访问
        initParams.put("deny", "192.168.15.21");    //禁止谁访问
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        
        bean.setInitParameters(initParams); //设置初始化参数
        
        return bean;
    }
    
    //filter 过滤器
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        
        bean.setFilter(new WebStatFilter());    //设置过滤器
        
        //过滤请求设置
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");    //这些文件不进行统计
        
        bean.setInitParameters(initParams); //设置初始化参数
        bean.setUrlPatterns(Arrays.asList("/*"));
        
        return bean;
    }
    
}
