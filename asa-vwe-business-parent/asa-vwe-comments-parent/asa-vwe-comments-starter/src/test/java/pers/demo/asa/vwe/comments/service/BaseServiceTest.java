package pers.demo.asa.vwe.comments.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.demo.asa.vwe.comments.starter.CommentsApplication;

import java.security.ProtectionDomain;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:54 2019/11/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CommentsApplication.class)
public class BaseServiceTest {
    protected Logger $ = LoggerFactory.getLogger(BaseServiceTest.class);
}