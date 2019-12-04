package pers.demo.asa.vwe.blog.api;

import org.springframework.web.bind.annotation.*;
import pers.demo.asa.vwe.blog.bean.BlogBean;
import pers.demo.asa.vwe.blog.bean.BlogUrl;
import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.common.controller.IController;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:43 2019/10/10.
 */
@RequestMapping(BlogUrl.ROOT)
public interface IBlogApi extends IController<BlogModel> {
    @GetMapping(BlogUrl.Blog.GET_BLOG_COMMENTS)
    BlogBean getBlogWithComments(@PathVariable("id") String id);
}