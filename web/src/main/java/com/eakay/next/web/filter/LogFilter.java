package com.eakay.next.web.filter;


import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LogFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getServletPath();
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.length() > 0) {
            path = path + pathInfo;
        }

        String params = getParams(request);

        String headers = getHeaders(request);

        long begin = System.currentTimeMillis();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            if ( path.startsWith("/druid") ) {
                return;
            }

            long timeUsed = System.currentTimeMillis() - begin;
            String info = String.format("{\"ip\":\"%s\", \"path\":\"%s\", \"params\":%s, \"headers\":%s, \"timeUsed\":%s}",
                    getRemoteIp(request),
                    path,
                    (StringUtils.isBlank(params) ? "null" : params),
                    (StringUtils.isBlank(headers) ? "null" : headers),
                    timeUsed);
            log.info(info);
        } catch (Exception e) {
            long timeUsed = System.currentTimeMillis() - begin;
            String error = String.format("{\"ip\":\"%s\", \"path\":\"%s\", \"params\":%s, \"headers\":%s, \"timeUsed\":%s}",
                    getRemoteIp(request),
                    path,
                    (StringUtils.isBlank(params) ? "null" : params),
                    (StringUtils.isBlank(headers) ? "null" : headers),
                    timeUsed);
            log.error(error, e);
        }

    }

    @Override
    public void destroy() {

    }

    private String getRemoteIp(HttpServletRequest request) {
        String xIp = request.getHeader("X-Real-IP");
        if (xIp != null && xIp.trim().length() > 0) return xIp;
        return request.getRemoteAddr();
    }

    private String getParams(HttpServletRequest request) {
        String params = "";
        Map<String, String[]> map = request.getParameterMap();
        if ( MapUtils.isNotEmpty(map) ) {
            params = JSON.toJSONString(map);
        }
        return params;
    }

    private String getHeaders(HttpServletRequest request) {
        String headerStr = "";
        /*Map<String, String> headMap = new HashMap<>();
        String[] headerKeyArray = HeaderConst.getHeaderKeyArray();
        if ( ArrayUtils.isNotEmpty(headerKeyArray) ) {
            for ( String key : headerKeyArray ) {
                String value = request.getHeader(key);
                if ( StringUtils.isNotBlank(value) ) {
                    headMap.put(key, value);
                }
            }
        }

        if ( MapUtils.isNotEmpty(headMap) ) {
            headerStr = JSON.toJSONString(headMap);
        }*/
        return headerStr;
    }


}
