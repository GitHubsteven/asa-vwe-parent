package pers.demo.asa.vwe.comments.api.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.vwe.comments.api.ICommentsApi;
import pers.demo.asa.vwe.comments.bean.constant.CommentsUrl;
import pers.demo.asa.vwe.comments.model.CommentsModel;
import pers.demo.asa.vwe.comments.service.impl.CommentsServiceImpl;
import pers.demo.asa.vwe.common.controller.IController;

import java.util.List;


/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:49 2019/10/29.
 */
@RestController
@RequestMapping(CommentsUrl.ROOT)
public class ICommentsImplCtrl implements ICommentsApi {
    private final CommentsServiceImpl iCommentsService;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public ICommentsImplCtrl(CommentsServiceImpl iCommentsService) {
        this.iCommentsService = iCommentsService;
    }

    @Override
    public int count(String blogId) {
        return iCommentsService.countComments(blogId);
    }

    @Override
    public List<CommentsModel> listBlogComments(String blogId) {
        CommentsModel checkModel = new CommentsModel();
        checkModel.setBlogId(blogId);
        QueryWrapper<CommentsModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(checkModel);
        return iCommentsService.list(queryWrapper);
    }

    @Override
    public CommentsModel getById(String id) {
        return iCommentsService.getById(Long.valueOf(id));
    }

    @Override
    public Boolean add(CommentsModel comments) {
        if (StringUtils.isEmpty(comments.getCreator())) {
            String creator = "comment add api";
            comments.setCreator(creator)
                    .setModifier(creator);
        }
        try {
            System.out.println("comment: " + objectMapper.writeValueAsString(comments));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return iCommentsService.save(comments);
    }

    @Override
    public Boolean deleteById(String id) {
        return iCommentsService.removeById(id);
    }

    @Override
    public Boolean updateBydId(CommentsModel updateModel, String id) {
        updateModel.setId(Integer.valueOf(id));
        return iCommentsService.updateById(updateModel);
    }

    @GetMapping("/get-by-name/{name}")
    public String getByName(@PathVariable("name") String name) {
        return name + ", this is from comments";
    }

    @GetMapping("/pure-get")
    public String getByName() {
        return "this is from comments";
    }
}