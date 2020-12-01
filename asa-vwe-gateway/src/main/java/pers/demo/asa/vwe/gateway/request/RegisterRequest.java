package pers.demo.asa.vwe.gateway.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

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
public class RegisterRequest implements Serializable {
    
    private String username;

    private String email;

    private String password;

    private String creator;

}
