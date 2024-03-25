package com.duan.commmon.core;


import com.duan.commmon.core.constants.CommonConstants;

/**
 * 项目统一返回编码
 * @author  duanmx
 * 2018-07-03
 */
public class CodeMsg {

    private int code;
    private String msg;
    private String error;


    public static CodeMsg codeMsg(int code){
        if (code==CommonConstants.RESULT_SUCCESS) {
            return SUCCESS;
        }
        if (code==CommonConstants.RESULT_SERVER_ERROR) {
            return SERVER_ERROR;
        }
        if (code==CommonConstants.RESULT_OPERATION_FAILED) {
            return OPERATION_FAILED;
        }  if (code==CommonConstants.RESULT_TOKEN_ERROR) {
            return TOKEN_ERROR;
        }
        if (code==CommonConstants.RESULT_NO_JURISDICTION) {
            return NO_JURISDICTION;
        }
        if (code==CommonConstants.RESULT_PARAMETER_VALIDATOR) {
            return PARAMETER_VALIDATOR;
        }
        return OPERATION_FAILED;
    }

    /**
     * 通用的错误码
     */
    private static final CodeMsg SUCCESS = new CodeMsg(CommonConstants.RESULT_SUCCESS,"成功");
    private static final CodeMsg SERVER_ERROR = new CodeMsg(CommonConstants.RESULT_SERVER_ERROR, "Server exception!,请联系管理员！");
    private static final CodeMsg OPERATION_FAILED = new CodeMsg(CommonConstants.RESULT_OPERATION_FAILED,"%s");
    private static final CodeMsg TOKEN_ERROR = new CodeMsg(CommonConstants.RESULT_TOKEN_ERROR,"token过期或token错误，请重新登录");
    private static final CodeMsg NO_JURISDICTION = new CodeMsg(CommonConstants.RESULT_NO_JURISDICTION,"无权限操作");
    private static final CodeMsg PARAMETER_VALIDATOR = new CodeMsg(CommonConstants.RESULT_PARAMETER_VALIDATOR,"%s");



    private CodeMsg() {
    }

    public CodeMsg(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public CodeMsg(int code, String msg, String error) {
        this.msg = msg;
        this.code = code;
        this.error = error;
    }



    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getError() {
        return error;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setError(String error) {
        this.error = error;
    }
}
