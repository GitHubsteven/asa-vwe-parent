package pers.demo.asa.vwe.comments.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.demo.asa.vwe.comments.model.CommentsModel;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:30 2019/10/30.
 */
@RequestMapping("/comments")
public interface ICommentsApi {
    /**
     * 测试api
     *
     * @return 测试api 结果
     */
    @GetMapping("/api1")
    String api1();

    /**
     * 统计blog的评论量
     *
     * @param blogId 博客id
     * @return 评论量
     */
    @GetMapping("/count")
    int count(@RequestParam(name = "blogId") String blogId);

    /**
     * 统计blog的评论量
     *
     * @param blogId 博客id
     * @return 评论量
     */
    @GetMapping("/listBlogComments")
    List<CommentsModel> listBlogComments(@RequestParam(name = "blogId") String blogId);

    /**
     * 通过id来获取comments
     *
     * @param id comments id
     * @return 评论内容
     */
    @GetMapping("/getById/{id}")
    CommentsModel getById(@PathVariable("id") String id);
}