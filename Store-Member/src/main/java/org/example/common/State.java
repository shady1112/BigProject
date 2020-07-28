package org.example.common;

/**
 * @author Shady
 */

public enum State {

    SUCCESS_CODE (200,"成功"),
    ERROR_CODE(500,"失败")
    ;

    State(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

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
}
