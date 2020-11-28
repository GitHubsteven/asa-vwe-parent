package pers.demo.asa.vwe.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/13
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"pers.demo.asa.vwe.cms.client"})
@MapperScan("pers.demo.asa.vwe.blog.dao")
public class VweCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(VweCmsApplication.class, args);
    }
}
