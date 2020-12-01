package pers.demo.asa.vwe.gateway.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pers.demo.asa.vwe.gateway.bean.AuthRequest;
import pers.demo.asa.vwe.gateway.bean.UserBean;
import pers.demo.asa.vwe.gateway.model.UserModel;
import pers.demo.asa.vwe.gateway.request.RegisterRequest;
import pers.demo.asa.vwe.gateway.response.AuthResponse;
import pers.demo.asa.vwe.gateway.service.IUserService;
import pers.demo.asa.vwe.gateway.utils.BCryptUtil;
import pers.demo.asa.vwe.gateway.utils.JwtTokenUtil;
import reactor.core.publisher.Mono;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/service/user")
public class UserController {
    private final JwtTokenUtil jwtTokenUtil;
    private final IUserService iUserService;

    public UserController(JwtTokenUtil jwtTokenUtil,
                          IUserService iUserService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.iUserService = iUserService;
    }

    @PostMapping("/authenticate")
    public Mono<AuthResponse> auth(@RequestBody AuthRequest request) {
        // duplication check
        final UserBean userBean = iUserService.loadUserByUserName(request.getUsername());
        if (userBean == null) {
            throw new RuntimeException("User not exist!");
        }
        // check password
        final boolean isPwdRight = BCryptUtil.compare(request.getPassword(), userBean.get_hash());
        if (!isPwdRight) {
            throw new RuntimeException("Password not right");
        }
        // create and return response
        return Mono.fromCallable(() -> {
            AuthResponse resp = new AuthResponse();
            resp.setToken(jwtTokenUtil.generateToken(userBean));
            resp.setUsername(userBean.getUsername());
            return resp;
        });
    }

    @GetMapping("/need-authe")
    public Mono<String> needAuthe() {
        String result = "business";
        return Mono.just(result);
    }

    @RequestMapping("/register")
    public Mono<Void> register(@RequestBody RegisterRequest request) {
        // check username
        final UserModel userModel = new UserModel();
        BeanUtils.copyProperties(request, userModel);
        iUserService.register(userModel);
        return Mono.empty();
    }
}
