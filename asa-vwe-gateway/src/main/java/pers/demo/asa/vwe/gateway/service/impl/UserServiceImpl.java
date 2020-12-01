package pers.demo.asa.vwe.gateway.service.impl;

import org.springframework.stereotype.Service;
import pers.demo.asa.vwe.gateway.bean.UserBean;
import pers.demo.asa.vwe.gateway.model.UserModel;
import pers.demo.asa.vwe.gateway.repository.UserRepository;
import pers.demo.asa.vwe.gateway.service.IUserService;
import pers.demo.asa.vwe.gateway.utils.BCryptUtil;
import pers.demo.asa.vwe.gateway.utils.SampleModelUtils;

import java.util.Collections;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class UserServiceImpl extends BaseService implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserBean loadUserByUserName(String userName) {
        final UserModel userModel = userRepository.findByUsername(userName);
        return userModel == null ? null : new UserBean(userModel.getUsername(), userModel.getHash(),
                Collections.singletonList(userModel.getRole()));
    }

    @Override
    public void register(UserModel user) {
        final UserModel existedUserByName = userRepository.findByUsername(user.getUsername());
        if (existedUserByName != null) {
            throw new RuntimeException(String.format("account[%s] has existed", user.getUsername()));
        }
        final String hash = BCryptUtil.hashPw(user.getUsername());
        user.setHash(hash);
        SampleModelUtils.setCreated(user, getUser().getUsername());
        userRepository.save(user);
    }
}
