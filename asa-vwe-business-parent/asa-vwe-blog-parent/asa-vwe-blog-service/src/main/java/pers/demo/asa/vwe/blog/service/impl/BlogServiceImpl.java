package pers.demo.asa.vwe.blog.service.impl;

import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.blog.dao.BlogDao;
import pers.demo.asa.vwe.blog.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
