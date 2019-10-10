package pers.demo.asa.vwe.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import pers.demo.asa.vvwe.business.common.model.BaseModel;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 15:14 2019/10/10.
 */
@Setter
@Getter
@Accessors(chain = true)
public class VWEBlogModel extends BaseModel<Long> {
    private String title;
    private String content;
    private String author;
}