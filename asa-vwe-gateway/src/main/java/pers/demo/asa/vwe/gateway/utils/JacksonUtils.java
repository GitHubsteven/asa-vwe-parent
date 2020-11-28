package pers.demo.asa.vwe.gateway.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/3/23
 * @CopyRight: COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class JacksonUtils {
    public static final ObjectMapper OM = new ObjectMapper();

    static {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        OM.setDateFormat(df);
        OM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OM.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static <T> T json2Bean(String json, Class<T> clz) {
        try {
            return OM.readValue(json, clz);
        } catch (IOException e) {
            throw new RuntimeException("pdd ark:object->json error! Message is: " + e.getMessage(), e);
        }
    }

    public static String toJson(Object object) {
        if (object == null) return null;
        try {
            return OM.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("pdd ark:json->object error! Message is: " + e.getMessage(), e);
        }
    }

    public static Map<String, Object> bean2Map(Object bean) {
        return OM.convertValue(bean, OM.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class));
    }

    public static <T> List<T> json2List(String json, Class<T> clz) {
        try {
            if (StringUtils.isEmpty(json)) return Collections.emptyList();
            return OM.readValue(json, OM.getTypeFactory().constructCollectionLikeType(List.class, clz));
        } catch (IOException e) {
            throw new RuntimeException("pdd ark:object->json error! Message is: " + e.getMessage(), e);
        }
    }
}
