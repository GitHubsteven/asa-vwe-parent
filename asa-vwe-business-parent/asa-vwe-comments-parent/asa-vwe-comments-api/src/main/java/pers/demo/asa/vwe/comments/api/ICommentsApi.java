package pers.demo.asa.vwe.comments.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pers.demo.asa.vwe.comments.bean.constant.CommentsUrl;
import pers.demo.asa.vwe.comments.model.CommentsModel;
import pers.demo.asa.vwe.common.constant.UrlConstant;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:30 2019/10/30.
 */
public interface ICommentsApi {

    /**
     * 增加
     *
     * @param model 增加的实例
     * @return 执行操作结果
     */
    @PostMapping(UrlConstant.DefaultUrl.ADD)
    default Boolean add(@RequestBody CommentsModel model) {
        return false;
    }


    /**
     * 删除model
     *
     * @param id 待删除的id
     * @return 删除结果
     */
    @GetMapping(UrlConstant.DefaultUrl.DELETE_BY_ID)
    default Boolean deleteById(@PathVariable("id") String id) {
        return false;
    }

    /**
     * 通过id来更新
     *
     * @param updateModel 待更新的信息
     * @return 更新的结果
     */
    @PostMapping(UrlConstant.DefaultUrl.UPDATE_BY_ID)
    default Boolean updateBydId(@RequestBody CommentsModel updateModel, @PathVariable("id") String id) {
        return false;
    }

    /**
     * 通过id来获取
     *
     * @param id id
     * @return 单个数据
     */
    @GetMapping(UrlConstant.DefaultUrl.GET_BY_ID)
    default CommentsModel getById(@PathVariable("id") String id) {
        return null;
    }

    /**
     * 统计blog的评论量
     *
     * @param blogId 博客id
     * @return 评论量
     */
    @GetMapping(CommentsUrl.Comments.COUNT_COMMENTS)
    int count(@PathVariable("blogId") String blogId);

    /**
     * 统计blog的评论量
     *
     * @param blogId 博客id
     * @return 评论量
     */
    @GetMapping(CommentsUrl.Comments.LIST_BLOG_COMMENTS)
    List<CommentsModel> listBlogComments(@PathVariable("blogId") String blogId);
}