package pers.demo.asa.vwe.blog.stater;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.demo.asa.vwe.blog.starter.VWEBlogApplication;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 21:02 2019/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VWEBlogApplication.class)
public class BaseTest {
    private Logger logger = LoggerFactory.getLogger(BaseTest.class);
}