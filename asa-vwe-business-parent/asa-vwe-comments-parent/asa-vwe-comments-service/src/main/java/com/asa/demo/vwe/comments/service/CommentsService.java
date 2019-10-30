package com.asa.demo.vwe.comments.service;

import org.springframework.stereotype.Service;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:24 2019/10/30.
 */
@Service
public class CommentsService implements ICommentsService {
    @Override
    public String api1() {
        return "api1";
    }
}