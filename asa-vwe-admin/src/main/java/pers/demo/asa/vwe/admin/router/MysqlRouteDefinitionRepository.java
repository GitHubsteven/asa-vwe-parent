package pers.demo.asa.vwe.admin.router;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;
import pers.demo.asa.vwe.admin.bean.RouteInfo;
import pers.demo.asa.vwe.admin.service.IRouteService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/26 13:26
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/26 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component
public class MysqlRouteDefinitionRepository implements RouteDefinitionRepository {

    public static final String GATEWAY_ROUTES = "gateway_routes";
    private final IRouteService iRouteService;

    public MysqlRouteDefinitionRepository(ObjectProvider<IRouteService> objectProvider) {
        this.iRouteService = objectProvider.getIfAvailable();
    }


    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteInfo> routerInfos = iRouteService.loadAll();
        final List<RouteDefinition> routers = routerInfos.stream()
                .map(routeInfo -> {
                    RouteDefinition definition = new RouteDefinition();
                    definition.setId(UUID.randomUUID().toString());
                    final URI uri = UriComponentsBuilder.fromUriString("lb://" + routeInfo.getServiceName()).build().toUri();
                    definition.setUri(uri);
                    //定义第一个断言
                    PredicateDefinition predicate = new PredicateDefinition(String.format("Path=/%s/**", routeInfo.getPath()));
                    //定义Filter
//        FilterDefinition filter = new FilterDefinition();
//        filter.setName("AddRequestHeader");
//        Map<String, String> filterParams = new HashMap<>(8);
//        //该_genkey_前缀是固定的，见org.springframework.cloud.gateway.support.NameUtils类
//        filterParams.put("_genkey_0", "header");
//        filterParams.put("_genkey_1", "addHeader");
//        filter.setArgs(filterParams);
//
//        FilterDefinition filter1 = new FilterDefinition();
//        filter1.setName("AddRequestParameter");
//        Map<String, String> filter1Params = new HashMap<>(8);
//        filter1Params.put("_genkey_0", "param");
//        filter1Params.put("_genkey_1", "addParam");
//        filter1.setArgs(filter1Params);
//
//        definition.setFilters(Arrays.asList(filter, filter1));
                    definition.setPredicates(Collections.singletonList(predicate));
                    System.out.println("definition id:" + definition.getId());
                    return definition;
                }).collect(Collectors.toList());
        // add definition
        return Flux.fromIterable(routers);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}

