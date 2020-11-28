package pers.demo.asa.vwe.blog.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.demo.asa.vwe.blog.BaseTest;
import pers.demo.asa.vwe.blog.model.BlogModel;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/8/18
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BlogDaoTest extends BaseTest {
    @Autowired
    private BlogDao blogDao;

    @Test
    public void testSelectWithPaged() {
        BlogModel blogModel = blogDao.selectById(1);
        System.out.println(blogModel.getAuthor());
    }
}
