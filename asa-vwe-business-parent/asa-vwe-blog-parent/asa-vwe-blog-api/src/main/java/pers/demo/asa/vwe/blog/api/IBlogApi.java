package pers.demo.asa.vwe.blog.api;

import org.springframework.web.bind.annotation.*;
import pers.demo.asa.vwe.blog.bean.BlogBean;
import pers.demo.asa.vwe.blog.bean.BlogUrl;
import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.blog.model.mongo.MBlogModel;
import pers.demo.asa.vwe.blog.request.BlogPageFilter;
import pers.demo.asa.vwe.common.controller.IController;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:43 2019/10/10.
 */
public interface IBlogApi extends IController<BlogModel> {
    /**
     * 通过blog id获取博客和下面的评论
     *
     * @param id 博客id
     * @return 博客和下面的评论
     */
    @GetMapping(BlogUrl.Blog.GET_BLOG_COMMENTS)
    BlogBean getBlogWithComments(@PathVariable("id") String id);

    /**
     * 分页查询
     *
     * @param filter 过滤条件
     * @return
     */
    @PostMapping(BlogUrl.Blog.LIST)
    List<MBlogModel> selectWithPage(@RequestBody BlogPageFilter filter);
}