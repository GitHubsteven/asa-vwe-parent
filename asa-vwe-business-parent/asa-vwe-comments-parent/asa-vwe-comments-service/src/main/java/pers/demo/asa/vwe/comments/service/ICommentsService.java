package pers.demo.asa.vwe.comments.service;

import pers.demo.asa.vwe.comments.model.CommentsModel;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:23 2019/10/30.
 */
public interface ICommentsService {
    /**
     * 测试 api
     *
     * @return 测试内容
     */
    String api1();

    /**
     * 计算数量
     *
     * @return 数量
     */
    int countComments();

    /**
     * 通过id来获取评论的内容
     *
     * @param id id
     * @return 评论内容
     */
    CommentsModel getById(long id);
}