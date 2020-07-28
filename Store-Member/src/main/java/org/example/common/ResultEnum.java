package org.example.common;

/**
 * 返回结果枚举<br/>
 * <br/>
 * 创建时间： 2017年12月12日 上午11:27:06 <br/>
 *
 * @author yaonp
 */
public enum ResultEnum {
    /**
     *
     */
    LOGINERROR(-1, "账号或密码输入不正确，请重新输入！"),
    TREADSTOP(999, "tread stop"),
    UNKONW_ERROR(-1, "未知错误"),
    COMMON(1, "一般问题或提示"),
    HATE_ERROR(444, "自定义讨厌的异常"),
    SUCCESS(0, "成功");

    /**
     * 编码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;


    /**
     * 构造函数
     *
     * @param code
     * @param msg
     */
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取编码
     *
     * @return 编码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取异常信息
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }
}
