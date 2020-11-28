package pers.demo.asa.vwe.gateway.bean;

import lombok.*;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommonResp<T> {
    private String code;
    private String message;
    private T data;

}
