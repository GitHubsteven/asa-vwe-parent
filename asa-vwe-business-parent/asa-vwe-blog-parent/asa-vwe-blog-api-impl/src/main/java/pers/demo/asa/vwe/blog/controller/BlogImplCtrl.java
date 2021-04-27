package pers.demo.asa.vwe.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.vwe.blog.api.IBlogApi;
import pers.demo.asa.vwe.blog.bean.BlogBean;
import pers.demo.asa.vwe.blog.bean.BlogUrl;
import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.blog.model.mongo.MBlogModel;
import pers.demo.asa.vwe.blog.request.BlogPageFilter;
import pers.demo.asa.vwe.blog.service.IBlogService;
import pers.demo.asa.vwe.comments.feign.client.CommentsClient;
import pers.demo.asa.vwe.comments.model.CommentsModel;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author asa.x
 * @since 2019-10-29
 */
@RequestMapping(BlogUrl.ROOT)
@RestController
public class BlogImplCtrl implements IBlogApi {
    @Value("${server.port}")
    private Integer port;

    private Logger logger = LoggerFactory.getLogger(BlogImplCtrl.class);
    private final static String creator = "BlogImplCtrl";

    private final IBlogService iBlogService;
    private final CommentsClient commentsClient;

    public BlogImplCtrl(IBlogService iBlogService, CommentsClient commentsClient) {
        this.iBlogService = iBlogService;
        this.commentsClient = commentsClient;
    }

    @Override
    public BlogBean getBlogWithComments(String id) {
        List<CommentsModel> comments = commentsClient.listBlogComments(String.valueOf(id));
        BlogModel blogModel = iBlogService.getById(Integer.valueOf(id));
        return new BlogBean().setBlog(blogModel)
                .setComments(comments);
    }

    @Override
    public Boolean add(BlogModel blog) {
        if (StringUtils.isEmpty(blog.getCreator())) {
            blog.setCreator(creator)
                    .setModifier(creator);
        }
        return iBlogService.save(blog);
    }

    @Override
    public Boolean deleteById(String id) {
        return iBlogService.removeById(id);
    }

    @Override
    public Boolean updateBydId(BlogModel updateModel, String id) {
        updateModel.setId(Integer.valueOf(id));
        return iBlogService.updateById(updateModel);
    }

    @Override
    public BlogModel getById(String id) {
        return iBlogService.getById(id);
    }

    @Override
    public List<BlogModel> list(Map<String, Object> params) {
        logger.info("----------params:{}", params);
        return iBlogService.list();
    }

    @Override
    public List<MBlogModel> selectWithPage(BlogPageFilter filter) {
        return null;
    }

    @GetMapping("/get-by-name/{name}")
    public String getByName(@PathVariable("name") String name) {
        return name + ", this is from blog" + port;
    }

    @GetMapping("/pure-get")
    public String getByName() {
        return "this is from blog" + port;
    }
}
