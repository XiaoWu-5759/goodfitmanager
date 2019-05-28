package com.simba.goodfitmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@MapperScan(basePackages = "com.simba.goodfitmanager.dao")
@EnableSwagger2
@ComponentScan({"com.simba.goodfitmanager"})
public class GoodfitmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodfitmanagerApplication.class, args);
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.simba.goodfitmanager.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("good fit manager apis")
                .description("配件管理系统中的 restful APIs")
//                .termsOfServiceUrl("https://github.com/zdRan/learning")
//                .contact(new Contact("个人开源项目组",
//                        "https://github.com/zdRan/learning",
//                        "cm.zdran@gmail.com"))
                .version("4.0")
                .build();
    }



}
