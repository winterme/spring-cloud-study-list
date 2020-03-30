package com.zzq.util;

import java.io.Serializable;

public class JsonResult implements Serializable {

    private String msg;
    private int code;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public JsonResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonResult(String msg, int code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static JsonResult getResult(int code, String msg) {
        return new JsonResult(code, msg);
    }

    public static JsonResult getResult(int code, String msg, Object data) {
        return new JsonResult(msg, code, data);
    }

}
