package pers.demo.asa.vwe.blog.starter.controller;

import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.vwe.blog.api.IBlogApi;
import pers.demo.asa.vwe.blog.model.VWEBlogModel;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:09 2019/10/10.
 */
@RestController
public class BlogController implements IBlogApi {
    /**
     * 根据id获取blog信息
     *
     * @param id blogId
     * @return blog信息
     */
    @Override
    public VWEBlogModel getBlogById(Long id) {
        return createById(id);
    }

    /**
     * 获取所有的博客信息
     *
     * @return 博客信息集合
     */
    @Override
    public List<VWEBlogModel> listBlogs() {
        return IntStream.range(0, 3)
                .mapToObj(it -> createById((long) it))
                .collect(Collectors.toList());
    }

    private VWEBlogModel createById(Long id) {
        VWEBlogModel blog = new VWEBlogModel();
        blog.setContent("java")
                .setAuthor("asa.x")
                .setTitle("blog" + id)
                .setCreateTime(new Date())
                .setModifiedTime(new Date())
                .setCreator("asa.x")
                .setModifier("asa.x");
        return blog;
    }

    @Override
    public int createBlog(VWEBlogModel blog) {
        return 0;
    }
}