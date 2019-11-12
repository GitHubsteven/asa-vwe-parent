package pers.demo.asa.vwe.comments.api.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.vwe.comments.api.ICommentsApi;
import pers.demo.asa.vwe.comments.model.CommentsModel;
import pers.demo.asa.vwe.comments.service.impl.CommentsServiceImpl;

import java.util.List;


/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:49 2019/10/29.
 */
@RestController
public class ICommentsImplCtrl implements ICommentsApi {
    private final CommentsServiceImpl iCommentsService;

    public ICommentsImplCtrl(CommentsServiceImpl iCommentsService) {
        this.iCommentsService = iCommentsService;
    }

    @Override
    public String api1() {
        return "comments service test, call result is: " + iCommentsService.api1();
    }

    @Override
    public int count(String blogId) {
        return iCommentsService.countComments(blogId);
    }

    @Override
    public List<CommentsModel> listBlogComments(String blogId) {
        CommentsModel checkModel = new CommentsModel();
        checkModel.setBlogId(blogId);
        QueryWrapper<CommentsModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(checkModel);
        return iCommentsService.list(queryWrapper);
    }

    @Override
    public CommentsModel getById(String id) {
        return iCommentsService.getById(Long.valueOf(id));
    }
}