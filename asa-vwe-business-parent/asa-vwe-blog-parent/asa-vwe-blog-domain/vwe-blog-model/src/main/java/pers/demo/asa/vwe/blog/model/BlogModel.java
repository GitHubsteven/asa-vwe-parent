package pers.demo.asa.vwe.blog.model;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.demo.asa.vwe.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author asa.x
 * @since 2019-10-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("vwe_blog")
public class BlogModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    private String title;

    private String author;

    private String content;


}
