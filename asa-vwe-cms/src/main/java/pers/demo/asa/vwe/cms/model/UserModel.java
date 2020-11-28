package pers.demo.asa.vwe.cms.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/13
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@Document("users")
public class UserModel {
    @Id
    private String id;
    private String password;
    private String role;
    private String creator;
    private String modifier;
    private String username;
    private String email;
    private String createTime;
    private String modifiedTime;
    private String hash;
}
