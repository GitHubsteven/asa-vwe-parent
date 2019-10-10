package pers.demo.asa.vwe.blog.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:59 2019/10/10.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class VWEBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(VWEBlogApplication.class, args);
    }
}