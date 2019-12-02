package pers.demo.asa.vwe.comments.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.demo.asa.vwe.comments.model.CommentsModel;
import pers.demo.asa.vwe.comments.service.BaseServiceTest;
import pers.demo.asa.vwe.comments.service.ICommentsService;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:57 2019/11/5.
 */
public class CommentsServiceTest extends BaseServiceTest {
    @Autowired
    private CommentsServiceImpl iCommentsService;

    @Test
    public void testCount() {
        Assert.assertEquals(1, iCommentsService.countComments("1"));
    }

    @Test
    public void testApi1() {
        $.info("------------------->" + iCommentsService.api1());
    }

    @Test
    public void test() {
        CommentsModel commentsModel = new CommentsModel();
        commentsModel.setEmail("test-email@vo.com");
        commentsModel.setContent("test content")
                .setCreator("CommentsServiceTest")
                .setModifier("CommentsServiceTest");
        boolean save = iCommentsService.save(commentsModel);
        Assert.assertTrue(save);
    }

    @Test
    public void testUpdate() {
        CommentsModel updateModel = new CommentsModel();
        updateModel.setBlogId("1")
                .setRemark("test update")
                .setId(1);
        boolean updateResult = iCommentsService.updateById(updateModel);
        Assert.assertTrue(updateResult);
    }

    @Test
    public void testDel() {
        CommentsModel delModel = new CommentsModel();
        delModel.setCreator("CommentsServiceTest");
        Wrapper<CommentsModel> commentsModelWrapper = new UpdateWrapper<>(delModel);
        boolean remove = iCommentsService.remove(commentsModelWrapper);
        Assert.assertTrue(remove);
    }
}