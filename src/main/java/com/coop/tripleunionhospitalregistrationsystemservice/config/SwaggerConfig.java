package com.coop.tripleunionhospitalregistrationsystemservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {    // http://localhost:9090/swagger-ui.html

    //配置Swagger的Bean实例
    @Bean
    public Docket docket(Environment environment) {

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        //获得项目环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("skywalker")
                .enable(flag)  //是否启用Swagger
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //basePackage 指定要扫描的包
                //withClassAnnotation 扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.skywalker.springbootlearn06swagger.controller"))
 //                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                //paths() 过滤什么路径
                //any() 扫描全部
                //none() 不扫描
                .paths(PathSelectors.ant("skywalker/**"))
                .build();
    }
    //配置多个Swagger分组
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("coop");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("24");
    }

    //配置Swagger信息 apiInfo
    private ApiInfo apiInfo() {

        //作者信息
        Contact contact = new Contact("skywalker","https://kunpeng24.cn","20201422@stu.nchu.edu.cn");

        return new ApiInfo(
                "24的swaggerAPI文档",
                "freedom is the oxygen of the soul",
                "v1.0",
                "https://kunpeng24.cn",
                contact,
                "Apache 2.0",
                "http: //www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }

}

