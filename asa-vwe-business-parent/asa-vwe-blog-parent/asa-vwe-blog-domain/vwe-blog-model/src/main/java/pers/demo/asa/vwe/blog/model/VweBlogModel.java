package pers.demo.asa.vwe.blog.model;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.demo.asa.vwe.common.model.BaseModel;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class VweBlogModel extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private String title;

    private String author;

    private String content;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;


}