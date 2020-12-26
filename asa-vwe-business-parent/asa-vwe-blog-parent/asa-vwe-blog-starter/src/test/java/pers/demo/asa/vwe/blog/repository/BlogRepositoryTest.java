package pers.demo.asa.vwe.blog.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pers.demo.asa.vwe.blog.BaseTest;
import pers.demo.asa.vwe.blog.model.mongo.MBlogModel;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/13
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BlogRepositoryTest extends BaseTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void findAllByAuthor() {
        List<MBlogModel> blogs = blogRepository.findAllByAuthor("test");
        blogs.forEach(System.out::println);
    }

    @Test
    public void method() {
        Criteria criteria = Criteria.where("title").regex("category.");
        Query query = new Query(criteria);
        List<MBlogModel> blogModels = mongoTemplate.find(query, MBlogModel.class);
        System.out.println(blogModels.size());
        blogModels.forEach(System.out::println);
    }

}
