package pers.demo.asa.vwe.comments.api;

import org.springframework.web.bind.annotation.*;
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
     * 通过id获取评论
     *
     * @param id 评论id
     * @return 评论
     */
    @GetMapping("/getById/{id}")
    CommentsModel getById(@PathVariable("id") String id);

    /**
     * 添加评论
     *
     * @param comments 评论
     * @return 添加结果，true表示成功，false表示失败
     */
    @PostMapping("/add")
    Boolean add(@RequestBody CommentsModel comments);
}