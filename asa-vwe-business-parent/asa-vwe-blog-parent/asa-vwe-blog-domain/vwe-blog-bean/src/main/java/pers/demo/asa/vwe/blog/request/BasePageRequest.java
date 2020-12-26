package pers.demo.asa.vwe.blog.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/19
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
public class BasePageRequest {
    private int pageSize = 10;
    private int page = 1;

    private List<Sort> sorts;

}
