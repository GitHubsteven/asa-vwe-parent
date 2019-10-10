package pers.demo.asa.vwe.blog.api;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pers.demo.asa.vwe.blog.bean.BlogUrlConstant;
import pers.demo.asa.vwe.blog.model.VWEBlogModel;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:43 2019/10/10.
 */
public interface IBlogApi {
    /**
     * 根据id获取blog信息
     *
     * @param id blogId
     * @return blog信息
     */
    @GetMapping(BlogUrlConstant.Blog.GET_BLOG_BY_ID)
    VWEBlogModel getBlogById(@PathVariable("id") Long id);

    /**
     * 获取所有的博客信息
     *
     * @return 博客信息集合
     */
    @GetMapping(BlogUrlConstant.Blog.LIST_BLOG)
    List<VWEBlogModel> listBlogs();

    // TODO: 2019/10/10 完善blog的接口定义和实现

    @PostMapping(BlogUrlConstant.Blog.CREATE_BLOG)
    int createBlog(@RequestBody VWEBlogModel blog);
}