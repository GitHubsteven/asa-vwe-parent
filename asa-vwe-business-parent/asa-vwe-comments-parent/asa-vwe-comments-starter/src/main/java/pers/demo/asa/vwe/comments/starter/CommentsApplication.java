package pers.demo.asa.vwe.comments.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:39 2019/10/30.
 */
@SpringBootApplication
@ComponentScan("pers.demo.asa.vwe.comments")
@MapperScan("pers.demo.asa.vwe.comments.dao")
public class CommentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentsApplication.class, args);
    }
}