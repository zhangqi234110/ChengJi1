package com.ssm.Common;

import java.util.Observer;

/**
 * Created by 张齐 on 2019/9/25.
 */
public class Common {
    private  int  code;
    private  String msg;
    private Object data;

    public Common() {
    }

    public Common(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
