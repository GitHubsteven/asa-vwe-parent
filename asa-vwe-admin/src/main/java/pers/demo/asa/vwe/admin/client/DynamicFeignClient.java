package pers.demo.asa.vwe.admin.client;

import feign.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/25 15:26
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/25 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component
public class DynamicFeignClient {

    public interface MyCall {
//        @RequestMapping(value = "/pure-get", method = RequestMethod.GET)
        @RequestLine("GET /pure-get")
        String pureGet();

        @RequestLine("GET /get-by-name/{name}")
//        @RequestMapping(value = "/get-by-name/{name}", method = RequestMethod.GET)
        String callService(@PathVariable("name") String name);
    }


    FeignClientBuilder feignClientBuilder;

    public DynamicFeignClient(@Autowired ApplicationContext appContext) {
        this.feignClientBuilder = new FeignClientBuilder(appContext);
    }

    /*
     * Dynamically call a service registered in the directory.
     */

    public String doCall(String serviceId, String name) {

        // create a feign client

        MyCall fc = this.feignClientBuilder.forType(MyCall.class, serviceId).build();

        // make the call

        return fc.callService(name);

    }

    public String pureGet(String serviceId) {

        // create a feign client

        MyCall fc = this.feignClientBuilder.forType(MyCall.class, serviceId).build();

        // make the call

        return fc.pureGet();

    }
}

