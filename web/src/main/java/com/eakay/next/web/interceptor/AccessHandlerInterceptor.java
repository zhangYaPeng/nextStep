package com.eakay.next.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccessHandlerInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${env}")
    private String env;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("当前环境: {}，调用了preHandle拦截", env);
        String version = request.getHeader("version");
        if ( version != null && version.compareToIgnoreCase("3.1.1") <= 0 ) {
            error(response, "1000", "版本号太小");
            return false;
        }
        return true;
    }


    private void error(HttpServletResponse response, String code, String msg) {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Map<String, Object> returnMap = new HashMap<>();
            Map<String, Object> headMap = new HashMap<>();
            Map<String, Object> bodyMap = new HashMap<>();

            headMap.put("code", code);
            headMap.put("msg", msg);
            returnMap.put("head", headMap);
            returnMap.put("body", bodyMap);
            JSONObject responseJSONObject = new JSONObject(returnMap);
            out.write(responseJSONObject.toString());
        } catch (IOException e) {
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
