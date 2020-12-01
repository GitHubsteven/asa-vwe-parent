package pers.demo.asa.vwe.gateway.service.impl;

import pers.demo.asa.vwe.gateway.bean.UserBean;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BaseService {
    /**
     * 获取登录用户信息
     *
     * @return 当前线程登录的用户
     */
    // TODO: 2020/11/30 增加用户的设置
    public static UserBean getUser() {
        return new UserBean("system", null, null);
    }
}
