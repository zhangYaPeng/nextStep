package com.eakay.next.web.controller;

import com.alibaba.fastjson.JSON;
import com.eakay.next.client.exceptions.CommonRuntimeException;
import com.eakay.next.client.util.response.ResponseObject;
import com.eakay.next.client.util.response.ResponseUtil;
import com.eakay.next.client.util.response.enums.MSGEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseObject handleException(HttpServletRequest request, BindException e) {
        logger.info("非法参数，原因：{}", JSON.toJSONString(e.getAllErrors()));
        return ResponseUtil.getError(MSGEnum.PARAMS_ERROR);
    }

    @ExceptionHandler(CommonRuntimeException.class)
    @ResponseBody
    public ResponseObject handleException(HttpServletRequest request, CommonRuntimeException e) {
        return ResponseUtil.getError(e.getMessage(), e.getCode());
    }

}
