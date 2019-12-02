package pers.demo.asa.vwe.comments.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.demo.asa.vwe.comments.dao.CommentsDao;
import pers.demo.asa.vwe.comments.model.CommentsModel;
import pers.demo.asa.vwe.comments.service.ICommentsService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author asa.x
 * @since 2019-10-31
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, CommentsModel> implements ICommentsService {
    @Autowired
    private CommentsDao commentsDao;

    @Override
    public String api1() {
        return "api1";
    }

    @Override
    public int countComments(String blogId) {
        return commentsDao.countComments(blogId);
    }

    @Override
    public CommentsModel getById(Integer id) {
        CommentsModel checkModel = new CommentsModel();
        checkModel.setId(id);
        QueryWrapper<CommentsModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(checkModel);
        return commentsDao.selectOne(queryWrapper);
    }
}
