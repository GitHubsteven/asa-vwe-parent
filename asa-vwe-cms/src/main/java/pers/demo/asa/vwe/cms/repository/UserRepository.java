package pers.demo.asa.vwe.cms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pers.demo.asa.vwe.cms.model.UserModel;

import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/9/14
 * @descrition:
 */
public interface UserRepository extends MongoRepository<UserModel, String> {
    /**
     * 通过名来查找
     *
     * @param firstName 名
     * @return 用户
     */
    UserModel findByUsername(String firstName);

    /**
     * 通过姓来查找
     *
     * @param lastName 姓
     * @return 用户
     */
    List<UserModel> findByCreator(String lastName);

}
