package pers.demo.asa.vwe.admin.service;

import pers.demo.asa.vwe.admin.bean.RouteInfo;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/26 17:30
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/26 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IRouteService {
    List<RouteInfo> loadAll();
}
