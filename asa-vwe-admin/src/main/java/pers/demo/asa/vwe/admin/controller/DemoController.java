package pers.demo.asa.vwe.admin.controller;

import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.vwe.admin.client.DynamicFeignClient;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/25 16:21
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/25 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/admin")
public class DemoController {
    private final Map<String, String> name2ServiceId = new HashMap<>(2);

    @PostConstruct
    public void init() {
        name2ServiceId.put("comments", "VWE-COMMENTS");
        name2ServiceId.put("blog", "VWE-BLOGS");
    }


    DynamicFeignClient dynamicFeignClient;

    public DemoController(DynamicFeignClient dynamicFeignClient) {
        this.dynamicFeignClient = dynamicFeignClient;
        name2ServiceId.put("blog", "");
        name2ServiceId.put("comments", "");
    }

    @GetMapping("/get-by-name/{name}")
    public String getByName(@PathVariable("name") String name) {
        return dynamicFeignClient.doCall(name2ServiceId.get(name), name);
    }

    @GetMapping("/pure-get")
    public String pureGet() {
        String name = RandomUtils.nextInt(10) % 2 == 0 ? "comments" : "blog";
        return dynamicFeignClient.pureGet(name2ServiceId.get(name));
    }

    @GetMapping("/custom-feign")
    public String customFeign() {
        String name = RandomUtils.nextInt(10) % 2 == 0 ? "comments" : "blog";

        final String serviceId = name2ServiceId.get(name);
        final DynamicFeignClient.MyCall client = Feign.builder().target(DynamicFeignClient.MyCall.class, serviceId);
        return client.pureGet();
    }
}

