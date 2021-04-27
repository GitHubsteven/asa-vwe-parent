package pers.demo.asa.vwe.blog.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import pers.demo.asa.vwe.blog.model.mongo.MBlogModel;
import pers.demo.asa.vwe.blog.repository.BlogRepository;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/19
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class MBlogServiceImpl {

    private final BlogRepository blogRepository;

    private final MongoTemplate mongoTemplate;

    public MBlogServiceImpl(BlogRepository blogRepository,
                            MongoTemplate mongoTemplate) {
        this.blogRepository = blogRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Page<MBlogModel> selectWithPage() {
        PageRequest request = PageRequest.of(1, 10, Sort.by("created").descending());
        Criteria criteria = new Criteria();
        Criteria.where("title").regex("");
//        mongoTemplate.find();
//        blogRepository.findAll(null, request);
        return null;
    }
}
