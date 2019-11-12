package pers.demo.asa.vwe.blog.controller;


import com.asa.demo.vwe.comments.feign.client.CommentsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.vwe.blog.api.IBlogApi;
import pers.demo.asa.vwe.blog.bean.BlogBean;
import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.blog.service.IBlogService;
import pers.demo.asa.vwe.comments.model.CommentsModel;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author asa.x
 * @since 2019-10-29
 */
@RestController
public class BlogImplCtrl implements IBlogApi {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private CommentsClient commentsClient;

    public BlogBean getBlogById(Long id) {
        List<CommentsModel> comments = commentsClient.listBlogComments(String.valueOf(id));
        BlogModel blogModel = iBlogService.getById(id);
        return new BlogBean().setBlogModel(blogModel)
                .setComments(comments);
    }

    public int createBlog(BlogModel blog) {
        return 0;
    }

    @Override
    public String testApi() {
        return "test api";
    }
}
