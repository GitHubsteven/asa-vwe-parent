package pers.demo.asa.vwe.admin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.demo.asa.vwe.admin.bean.RouteInfo;

import java.util.Arrays;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/26 17:38
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/26 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
@Slf4j
public class IRouteServiceImpl implements IRouteService {
    @Override
    public List<RouteInfo> loadAll() {
        List<RouteInfo> baseRouters = Arrays.asList(new RouteInfo("comments", "vwe-comments"),
                new RouteInfo("blog", "vwe-blogs"));
        final boolean isAppendRouter = System.currentTimeMillis() % 2 == 0;
        if (isAppendRouter) {
            baseRouters.add(new RouteInfo("test", "vwe-test"));
        }
        return baseRouters;
    }
}

