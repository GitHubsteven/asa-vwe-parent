package pers.demo.asa.vwe.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.demo.asa.vwe.blog.model.BlogModel;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author asa.x
 * @since 2019-10-29
 */
public interface IBlogService extends IService<BlogModel> {
    /**
     * 分页查询
     *
     * @param page       分页信息
     * @param checkModel 查询参数
     * @return 查询结果
     */
    IPage<BlogModel> selectBlogPage(Page<BlogModel> page, BlogModel checkModel);
}
