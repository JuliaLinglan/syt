package com.linglan.syt.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@ComponentScan(basePackages = "com.linglan")
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages = "com.linglan")
@SpringBootApplication
@EnableConfigurationProperties
@EnableSwagger2
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
