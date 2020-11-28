package pers.demo.asa.vwe.gateway.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 18:32 2019/8/29.
 */
@Setter
@Getter
public class DemoRequest {
    private String username;
    private String password;
    private String requestId;
}