package pers.demo.asa.vwe.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 15:59 2019/10/10.
 */
@SpringBootApplication
@EnableEurekaServer
public class VWEEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(VWEEurekaServerApplication.class, args);
    }
}