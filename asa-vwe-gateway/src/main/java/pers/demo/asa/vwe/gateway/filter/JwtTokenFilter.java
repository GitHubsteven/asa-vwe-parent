package pers.demo.asa.vwe.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import pers.demo.asa.vwe.gateway.bean.CommonResp;
import pers.demo.asa.vwe.gateway.bean.GatewayConstants;
import pers.demo.asa.vwe.gateway.bean.UserBean;
import pers.demo.asa.vwe.gateway.config.SecurityProperties;
import pers.demo.asa.vwe.gateway.service.IUserService;
import pers.demo.asa.vwe.gateway.utils.JacksonUtils;
import pers.demo.asa.vwe.gateway.utils.JwtTokenUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description jwtToken验证
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Slf4j
@Component
public class JwtTokenFilter implements GlobalFilter, Ordered {

    private final SecurityProperties securityProperties;
    private final JwtTokenUtil jwtTokenUtil;
    private final IUserService iUserService;

    public JwtTokenFilter(SecurityProperties securityProperties,
                          JwtTokenUtil jwtTokenUtil,
                          IUserService iUserService) {
        this.securityProperties = securityProperties;
        this.jwtTokenUtil = jwtTokenUtil;
        this.iUserService = iUserService;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("---------> start jwtTokenFilter!");
        final String path = exchange.getRequest().getPath().value();
        if (securityProperties.getIgnoreUrls().contains(path)) {
            return chain.filter(exchange);
        }
        // get token
        final List<String> bearerTokens = exchange.getRequest().getHeaders()
                .get(GatewayConstants.HeaderKey.AUTHORIZATION);
        String token = "";
        final ServerHttpResponse response = exchange.getResponse();
        if (!CollectionUtils.isEmpty(bearerTokens)) {
            final String tokenInfo = bearerTokens.get(0);
            if (!tokenInfo.startsWith(GatewayConstants.BEARER_START)) {
                return writeError(response, "not support authorization!");
            }
            token = tokenInfo.split(" ")[1];
        }
        // check the token
        if (StringUtils.isEmpty(token)) {
            return writeError(response, "null token");
        }
        String username = jwtTokenUtil.getUsernameFromToken(token);
        // get userBean by user;
        UserBean userBean = iUserService.loadUserByUserName(username);
        try {
            jwtTokenUtil.validateToken(token, userBean);
            return chain.filter(exchange);
        } catch (Exception e) {
            return writeError(response, e.getLocalizedMessage());
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 认证错误输出
     *
     * @param resp 响应对象
     * @param mess 错误信息
     */
    private Mono<Void> writeError(ServerHttpResponse resp, String mess) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        CommonResp<String> returnData = new CommonResp<String>(String.valueOf(HttpStatus.UNAUTHORIZED),
                mess, null);
        String returnStr = JacksonUtils.toJson(returnData);
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }
}
