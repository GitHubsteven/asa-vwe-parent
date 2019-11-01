package pers.demo.asa.vwe.comments.dao;

import pers.demo.asa.vwe.comments.model.CommentsModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author asa.x
 * @since 2019-10-31
 */
public interface CommentsDao extends BaseMapper<CommentsModel> {
    /**
     * 统计数量
     *
     * @return 数量
     */
    int countComments();
}
