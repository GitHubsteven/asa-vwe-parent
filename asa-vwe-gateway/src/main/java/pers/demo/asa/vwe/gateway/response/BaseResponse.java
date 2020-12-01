package pers.demo.asa.vwe.gateway.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/1
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
public class BaseResponse {

    private String code;

    private String message;

    private Object data;

}
