package pers.demo.asa.vwe.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.demo.asa.vwe.blog.model.BlogModel;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author voerp-mybatis-generator
 * @since 2019-11-08
 */
@Repository
public interface BlogDao extends BaseMapper<BlogModel> {
    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page  分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param model 查询参数
     * @return 分页对象
     */
    IPage<BlogModel> selectWithPage(Page<?> page, @Param("model") BlogModel model);
}
