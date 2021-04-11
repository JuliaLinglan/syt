package com.linglan.syt.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


//@SpringBootApplication
//@ComponentScan(basePackages = "com.linglan")
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages = "com.linglan")
@SpringBootApplication
@EnableConfigurationProperties
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
