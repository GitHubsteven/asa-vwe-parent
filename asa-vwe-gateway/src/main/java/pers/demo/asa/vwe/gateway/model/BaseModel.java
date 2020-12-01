package pers.demo.asa.vwe.gateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@ToString
public class BaseModel implements Serializable {
    @Id
    private String id;

    private LocalDate createTime;

    private String creator;

    private LocalDate modifiedTime;

    private String modifier;
}
