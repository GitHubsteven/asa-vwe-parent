package pers.demo.asa.vwe.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 15:14 2019/10/15.
 */
@Setter
@Getter
@Accessors(chain = true)
public class BaseModel {
    private Long id;
    private Date createTime;
    private Date modifiedTime;
    private String creator;
    private String modifier;
}