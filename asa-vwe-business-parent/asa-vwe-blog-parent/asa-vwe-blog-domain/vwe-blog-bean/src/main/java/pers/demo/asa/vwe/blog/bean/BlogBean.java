package pers.demo.asa.vwe.blog.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import pers.demo.asa.vwe.blog.model.BlogModel;
import pers.demo.asa.vwe.comments.model.CommentsModel;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:34 2019/11/11.
 */
@Setter
@Getter
@Accessors(chain = true)
public class BlogBean implements Serializable {
    private BlogModel blog;
    private List<CommentsModel> comments;
}