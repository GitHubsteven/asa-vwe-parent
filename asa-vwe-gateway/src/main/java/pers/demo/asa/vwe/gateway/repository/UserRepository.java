package pers.demo.asa.vwe.gateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pers.demo.asa.vwe.gateway.model.UserModel;

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

}
