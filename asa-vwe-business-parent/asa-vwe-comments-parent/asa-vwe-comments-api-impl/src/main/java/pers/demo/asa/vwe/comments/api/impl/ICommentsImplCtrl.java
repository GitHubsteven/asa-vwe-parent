package pers.demo.asa.vwe.comments.api.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.vwe.comments.api.ICommentApi;
import pers.demo.asa.vwe.comments.dao.CommentsDao;
import pers.demo.asa.vwe.comments.model.CommentsModel;
import pers.demo.asa.vwe.comments.service.ICommentsService;


/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:49 2019/10/29.
 */
@RestController
@RequestMapping("/comments")
public class ICommentsImplCtrl implements ICommentApi {
    @Autowired
    private ICommentsService iCommentsService;
    @Autowired
    private CommentsDao commentsDao;

    @GetMapping("/api1")
    public String api1() {
        return "comments service test, call result is: " + iCommentsService.api1();
    }

    @GetMapping("/count")
    public int count() {
        return commentsDao.countComments();
    }

    @GetMapping("/getById/{id}")
    public CommentsModel getById(@PathVariable("id") Long id) {
        CommentsModel checkModel = new CommentsModel();
        checkModel.setId(id);
        QueryWrapper<CommentsModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(checkModel);
        return commentsDao.selectOne(queryWrapper);
//        return commentsDao.selectOne(checkModel);
    }
}