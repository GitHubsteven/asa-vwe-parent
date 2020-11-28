package pers.demo.asa.vwe.gateway.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.demo.asa.vwe.gateway.bean.CommonResp;

/**
 * @author jet.xie
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @description:
 * @date: Created at 15:06 2019/8/9.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp<String> defaultErrorHandler(Exception e) throws Exception {
        logger.error("", e);
        CommonResp<String> r = new CommonResp<>();
        r.setMessage(e.getMessage());
        r.setCode("500");
        return r;
    }
}