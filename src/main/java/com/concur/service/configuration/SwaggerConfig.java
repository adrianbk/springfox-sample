package com.concur.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@ComponentScan(basePackages = "com.concur.service.api")
@EnableWebMvc
@EnableSwagger2 //Loads the spring beans required by the framework
public class SwaggerConfig {

    @Bean
    ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
        "Swagger Petstore",
        "This is a sample server Petstore server.  You can find out more about Swagger at &lt;a href=&quot;http://swagger.io&quot;&gt;http://swagger.io&lt;/a&gt; or on irc.freenode.net, #swagger.  For this sample, you can use the api key &quot;special-key&quot; to test the authorization filters",
        "1.0.0",
        "My Apps API terms of service",
        "apiteam@wordnik.com",
        "Apache 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0.html" );
        return apiInfo;
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

}