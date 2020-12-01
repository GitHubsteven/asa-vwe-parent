package pers.demo.asa.vwe.gateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@ToString
@Document("users")
public class UserModel extends BaseModel {

    private String username;

    private String hash;

    private String email;

    private String password;

    private String role;

}
