package com.eakay.next.client.util.response;


import com.eakay.next.client.util.response.enums.MSGEnum;

public class ResponseUtil {

    private static MSG okMsg = new MSG();

    public static ResponseObject getOK() {
        ResponseObject response = new ResponseObject();
        response.setMsg(okMsg);
        return response;
    }

    public static ResponseObject getOKWithInfo(String info) {
        ResponseObject response = new ResponseObject();
        MSG msg = new MSG();
        msg.setInfo(info);
        response.setMsg(msg);
        return response;
    }

    public static ResponseObject getOK(Object object) {
        ResponseObject response = new ResponseObject();
        MSG msg = new MSG();
        response.setMsg(msg);
        response.setData(object);
        return response;
    }

    public static ResponseObject getOK(int code, String info, Object object) {
        ResponseObject response = new ResponseObject();
        MSG msg = new MSG();
        msg.setCode(code);
        msg.setInfo(info);
        response.setMsg(msg);
        response.setData(object);
        return response;
    }

    public static ResponseObject getOK(String info, Object object) {
        ResponseObject response = new ResponseObject();
        MSG msg = new MSG();
        msg.setInfo(info);
        response.setMsg(msg);
        response.setData(object);
        return response;
    }

    public static ResponseObject getError(String info) {
        ResponseObject response = new ResponseObject();
        MSG msg = new MSG();
        msg.setInfo(info);
        msg.setErrorCode();
        msg.setSuccess(false);
        response.setMsg(msg);
        return response;
    }

    public static ResponseObject getError(String info, Integer code) {
        ResponseObject response = new ResponseObject();
        MSG msg = new MSG();
        msg.setInfo(info);
        msg.setCode(code);
        msg.setSuccess(false);
        response.setMsg(msg);
        return response;
    }

    public static ResponseObject getError(MSGEnum headEnum) {
        ResponseObject response = new ResponseObject();
        MSG msg = new MSG();
        msg.setInfo(headEnum.getInfo());
        msg.setCode(headEnum.getCode());
        msg.setSuccess(false);
        response.setMsg(msg);
        return response;
    }

}
