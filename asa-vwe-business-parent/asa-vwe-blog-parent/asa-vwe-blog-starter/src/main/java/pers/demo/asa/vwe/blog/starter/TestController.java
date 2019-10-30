package pers.demo.asa.vwe.blog.starter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:34 2019/10/29.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/getById/{id}")
    public String getById(@PathVariable("id") Long id) {
        return "test" + id;
    }
}