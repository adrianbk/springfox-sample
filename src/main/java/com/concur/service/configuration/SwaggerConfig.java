package com.concur.service.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springdox.documentation.swagger2.annotations.EnableSwagger2;
import springdox.documentation.spring.web.plugins.DocumentationConfigurer;

import springdox.documentation.spi.DocumentationType;
import springdox.documentation.service.ApiInfo;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Set;


@Configuration
@EnableWebMvc
@EnableSwagger2 //Loads the spring beans required by the framework
public class SwaggerConfig {

private DocumentationConfigurer documentationConfigurer;

    @Autowired
    public void setDocumentationConfigurer(DocumentationConfigurer configurer){
        this.documentationConfigurer = documentationConfigurer;
    }

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
    public DocumentationConfigurer customImplementation(){
        return new DocumentationConfigurer(DocumentationType.SWAGGER_2)
            .groupName("default")
            .includePatterns(".*replace Swagger Petstore with your api classes.*")
            .apiInfo(apiInfo());
    }

    @Bean
    ObjectMapper objectMapper() { return new ObjectMapper(); }

}