package org.example.common;

import java.io.Serializable;

/**
 * 操作结果集<br/>
 * <br/>
 * 创建时间： 2016年8月29日 下午4:58:05 <br/>
 * 
 * @author yaonp
 */
public class Result implements Serializable {

    public static final int SUCCESS = 1;
    public static final int FAILURE = -1;

    private static final long serialVersionUID = 5576237395711742681L;

    /** 错误码. */
    private Integer code;

    /** 成功失败标志 */
    private boolean success = false;

    /** 消息内容 **/
    private String msg = "";

    /** 返回结果 */
    private Object obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", success=" + success + ", msg=" + msg + ", obj=" + obj + "]";
    }

}
