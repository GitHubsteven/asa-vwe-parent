package pers.demo.asa.vwe.gateway.service.impl;

import org.springframework.stereotype.Service;
import org.synchronoss.cloud.nio.multipart.util.IOUtils;
import pers.demo.asa.vwe.gateway.bean.UserBean;
import pers.demo.asa.vwe.gateway.service.IUserService;
import pers.demo.asa.vwe.gateway.utils.JacksonUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public UserBean loadUserByUserName(String userName) {
        return listUsers().stream()
                .filter(it -> Objects.equals(it.getUsername(), userName))
                .findFirst()
                .orElse(null);
    }


    public List<UserBean> listUsers() {
        try (final InputStream userResources = this.getClass().getClassLoader().getResourceAsStream("users.json")) {
            Objects.requireNonNull(userResources);
            final String usersJson = IOUtils.inputStreamAsString(userResources, "utf-8");
            return JacksonUtils.json2List(usersJson, UserBean.class);
        } catch (IOException e) {
            throw new RuntimeException("get users failed!", e);
        }
    }
}
