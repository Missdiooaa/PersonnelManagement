package cn.dio.personnelmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {

        Contact contact = new Contact("dio", "https://github.com/Missdiooaa", "miss_dio@163.com");

        return new Docket(DocumentationType.SWAGGER_2)
                // 配置页面头部展示的信息
                .apiInfo(new ApiInfo("Personnel Management Api Documentation",
                        "Api Documentation",
                        "1.0",
                        "https://www.baidu.com",
                        contact,
                        "Apache 2.0",
                        "http://www.apache.org/licenses/LICENSE-2.0",
                        new ArrayList()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.dio.personnelmanagement.controller"))
                .build();
    }

}
