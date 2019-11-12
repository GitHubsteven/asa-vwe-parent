package pers.demo.asa.vwe.blog.api;

import org.springframework.web.bind.annotation.*;
import pers.demo.asa.vwe.blog.bean.BlogBean;
import pers.demo.asa.vwe.blog.bean.BlogUrlConstant;
import pers.demo.asa.vwe.blog.model.BlogModel;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:43 2019/10/10.
 */
@RequestMapping("/blog")
public interface IBlogApi {
    /**
     * 根据id获取blog信息
     *
     * @param id blogId
     * @return blog信息
     */
    @GetMapping(BlogUrlConstant.Blog.GET_BLOG_BY_ID)
    BlogBean getBlogById(@PathVariable("id") Long id);


    /**
     * 生成blog
     *
     * @param blog blog信息
     * @return 生成的blog的数量
     */
    @PostMapping(BlogUrlConstant.Blog.CREATE_BLOG)
    int createBlog(@RequestBody BlogModel blog);

    @GetMapping("/test")
    String testApi();
}