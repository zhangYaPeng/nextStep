package com.test.app.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class AppClient {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String httpPost(String strUrl,Map<String, String> params, Map<String, String> headMap) {
        URL url = null;
        HttpURLConnection con = null;
        //构建请求参数
        StringBuffer sb = new StringBuffer();
        if ((params!=null)&&(params.size()>0)) {
            for (Map.Entry<String, String> e : params.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
        }
        logger.debug("http request "+strUrl+" "+((sb.length()>2)?sb.substring(0, sb.length() - 1):sb.toString()));
        //尝试发送请求
        try {
            url = new URL(strUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);

            if ( headMap != null ) {
                Set<String> keySet = headMap.keySet();
                for ( String key : keySet ) {
                    con.setRequestProperty(key, headMap.get(key));
                }
            }


            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "utf-8");
            osw.write(sb.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            logger.error("http post error",e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        //读取返回内容
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            logger.error("receive http reply error",e);
        }
        return buffer.toString();
    }
    
}
