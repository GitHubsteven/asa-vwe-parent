package pers.demo.asa.vwe.blog.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.demo.asa.vwe.common.model.BaseModel;

/**
 * <p>
 *
 * </p>
 *
 * @author voerp-mybatis-generator
 * @since 2019-11-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("vwe_blog")
public class BlogModel extends BaseModel<Integer> {

    private static final long serialVersionUID = 1L;

    private String title;

    private String author;

    private String content;
}
