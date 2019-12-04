package pers.demo.asa.vwe.comments.api;

import org.springframework.web.bind.annotation.*;
import pers.demo.asa.vwe.comments.bean.constant.CommentsUrl;
import pers.demo.asa.vwe.comments.model.CommentsModel;
import pers.demo.asa.vwe.common.controller.IController;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:30 2019/10/30.
 */
@RequestMapping(CommentsUrl.ROOT)
public interface ICommentsApi extends IController<CommentsModel> {
    /**
     * 统计blog的评论量
     *
     * @param blogId 博客id
     * @return 评论量
     */
    @GetMapping(CommentsUrl.Comments.COUNT_COMMENTS)
    int count(@PathVariable("blogId") String blogId);

    /**
     * 统计blog的评论量
     *
     * @param blogId 博客id
     * @return 评论量
     */
    @GetMapping(CommentsUrl.Comments.LIST_BLOG_COMMENTS)
    List<CommentsModel> listBlogComments(@PathVariable("blogId") String blogId);
}