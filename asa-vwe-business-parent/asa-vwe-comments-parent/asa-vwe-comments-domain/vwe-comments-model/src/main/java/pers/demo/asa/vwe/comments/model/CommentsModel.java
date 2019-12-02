package pers.demo.asa.vwe.comments.model;

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
 * @since 2019-10-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("vwe_comments")
public class CommentsModel extends BaseModel<Integer> {

    private static final long serialVersionUID = 1L;

    private String content;

    private String blogId;

    private String email;

    private String refId;

    private String remark;

    private String subComments;


}
