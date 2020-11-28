package pers.demo.asa.vwe.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Slf4j
@Configuration
public class LoggingGlobalFiltersConfigurations {
    @Bean
    public GlobalFilter timeGlobalFilter() {
        return (exchange, chain) -> {
            final long start = System.currentTimeMillis();
            log.info("--------> request start at:{}", start);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                final long end = System.currentTimeMillis();
                log.info("--------->request end at:{} and cost(ms)：{}", end, (end - start));
            }));
        };
    }
}
