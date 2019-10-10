package pers.demo.asa.vvwe.business.common.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:22 2019/10/10.
 */
@Setter
@Getter
public class BaseModel<T> {
    private T id;
    private Date createTime;
    private String creator;
    private Date modifiedTime;
    private String modifier;
}