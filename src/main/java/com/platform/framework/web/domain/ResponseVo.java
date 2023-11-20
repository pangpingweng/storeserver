package com.platform.framework.web.domain;

import com.platform.common.constant.HttpStatus;

import java.io.Serializable;

/**
 * <p>
 * Title: ResponseVo
 * </p>
 * <p>
 * Description: 响应基础类
 * </p>
 *
 * @author wanglei
 * @since 2018年7月31日
 */
public class ResponseVo<T> implements Serializable {

    private static final long serialVersionUID = 3236329195874147801L;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应结果
     */
    private T data;

    public ResponseVo() {
        this.code = HttpStatus.SUCCESS;
        this.msg = "success";
    }

    public ResponseVo(Integer code) {
        this.code = code;
    }

    public ResponseVo(T data) {
        this.code = HttpStatus.SUCCESS;
        this.data = data;
        this.msg = "success";
    }

    public ResponseVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseVo<T> ok() {
        return new ResponseVo<>();
    }

    public static <T> ResponseVo<T> ok(T t) {
        return new ResponseVo<>(t);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
