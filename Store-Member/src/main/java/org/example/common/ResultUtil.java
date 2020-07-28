package org.example.common;



/**
 * 返回结果工具类<br/>
 * <br/>
 * 创建时间： 2017年12月12日 上午11:21:02 <br/>
 * 
 * @author yaonp
 */
public class ResultUtil {

    /**
     * 返回正确结果 <br/>
     * 
     * @author yaonp
     * @param object 返回结果对象
     * @return result
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setSuccess(true);
        result.setMsg("成功");
        result.setObj(object);
        return result;
    }

    /**
     * 返回正确结果 <br/>
     * 
     * @author yaonp
     * @return result
     */
    public static Result success() {
        return success(true);
    }

    /**
     * 返回错误结果 <br/>
     * 
     * @author yaonp
     * @param code 错误码
     * @param msg 错误信息
     * @return result
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回错误结果 <br/>
     * 
     * @author yaonp
     * @param msg 错误信息
     * @return result
     */
    public static Result    error(String msg) {
        Result result = new Result();
        result.setCode(1);
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回错误结果 <br/>
     * 
     * @author yaonp
     * @param resultEnum 返回结果错误枚举
     * @return result
     */
    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setSuccess(false);
        result.setMsg(resultEnum.getMsg());
        return result;
    }
}
