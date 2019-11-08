package pers.demo.asa.vwe.blog.stater.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.blog.service.IBlogService;
import pers.demo.asa.vwe.blog.stater.BaseTest;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 21:04 2019/11/8.
 */
public class BlogServiceTest extends BaseTest {
    @Autowired
    private IBlogService iBlogService;

    @Test
    public void testGetById() {
        BlogModel blog = iBlogService.getById(1);
        System.out.println(blog.getContent());
    }
}