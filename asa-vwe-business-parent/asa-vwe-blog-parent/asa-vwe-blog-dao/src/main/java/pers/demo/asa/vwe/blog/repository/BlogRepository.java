package pers.demo.asa.vwe.blog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pers.demo.asa.vwe.blog.model.mongo.BlogModel;

import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/9/14
 * @descrition:
 */
public interface BlogRepository extends MongoRepository<BlogModel, String> {
    /**
     * 通过名来查找
     *
     * @param author 名
     * @return 用户
     */
    List<BlogModel> findAllByAuthor(String author);

}
