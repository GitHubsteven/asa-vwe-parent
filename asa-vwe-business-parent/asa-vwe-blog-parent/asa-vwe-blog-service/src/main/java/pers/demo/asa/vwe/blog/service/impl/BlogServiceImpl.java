package pers.demo.asa.vwe.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.demo.asa.vwe.blog.dao.BlogDao;
import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.blog.service.IBlogService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author asa.x
 * @since 2019-10-29
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogDao, BlogModel> implements IBlogService {

    @Override
    public IPage<BlogModel> selectBlogPage(Page<BlogModel> page, BlogModel checkModel) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return baseMapper.selectWithPage(page, checkModel);
    }
}
