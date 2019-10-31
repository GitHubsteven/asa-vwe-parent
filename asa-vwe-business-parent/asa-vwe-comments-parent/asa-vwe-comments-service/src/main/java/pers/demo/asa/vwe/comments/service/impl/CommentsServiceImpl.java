package pers.demo.asa.vwe.comments.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public String api1() {
        return "api1";
    }
}
