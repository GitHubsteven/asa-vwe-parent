package pers.demo.asa.vwe.comments.model;

import lombok.Getter;
import lombok.Setter;
import pers.demo.asa.vwe.common.model.BaseModel;

import java.util.Date;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:22 2019/10/10.
 */
@Setter
@Getter
public class VWECommentsModel extends BaseModel {
    private String content;
    private String blogId;
    private String email;
    private String refId;
    private String remark;
    private String subComments;
}