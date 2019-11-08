package pers.demo.asa.vwe.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.vwe.blog.api.IBlogApi;
import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.blog.service.IBlogService;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author asa.x
 * @since 2019-10-29
 */
@RestController
@RequestMapping("/blog")
public class BlogImplCtrl implements IBlogApi {
    @Autowired
    private IBlogService iBlogService;


    public BlogModel getBlogById(Long id) {
        return iBlogService.getById(id);
    }

    public int createBlog(BlogModel blog) {
        return 0;
    }
}
