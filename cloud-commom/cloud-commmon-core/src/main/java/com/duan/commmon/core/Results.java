package com.duan.commmon.core;



import com.duan.commmon.core.constants.CommonConstants;

import java.io.Serializable;
/**
 * 项目统一返回对象
 * @author duanmx
 * 2018-07-03
 */
public class Results<T> implements Serializable {


    private int code;
    private String msg;
    private String error;
    private T data;


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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Results(T data) {
        this.data = data;
        CodeMsg codeMsg = CodeMsg.codeMsg(CommonConstants.RESULT_SUCCESS);
        this.code=codeMsg.getCode();
        this.msg=codeMsg.getMsg();
    }


    private Results(int code, String msg) {
        this.code = code;
        this.msg = msg;
        CodeMsg codeMsg = CodeMsg.codeMsg(CommonConstants.RESULT_SUCCESS);
        this.code=codeMsg.getCode();
        this.msg=codeMsg.getMsg();
    }




    private Results(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }



    /**
     * 成功时候的调用
     * @param <T> T
     * @return Results
     */
    public static  <T> Results<T> success(){
        CodeMsg codeMsg = CodeMsg.codeMsg(CommonConstants.RESULT_SUCCESS);
        return new Results<T>(codeMsg);
    }


    /**
     *成功时候的调用
     * @param data data
     * @param <T> t
     * @return Results
     */
    public static  <T> Results<T> success(T data){
        return new Results<T>(data);
    }


    /**
     * 失败时候的调用
     * @param errorCode errorCode 详情见 CommonConstants RESULT_**
     * @param <T> t
     * @return Results
     */
    public static  <T> Results<T> error(int errorCode){
        CodeMsg codeMsg = CodeMsg.codeMsg(errorCode);
        if (errorCode==CommonConstants.RESULT_OPERATION_FAILED){
            codeMsg.setMsg("操作失败!");
        }
        return new Results<T>(codeMsg);
    }


    /**
     * 失败时候的调用
     * @param errorCode errorCode 详情见 CommonConstants RESULT_**
     * @param <T> t
     * @return Results
     */
    public static  <T> Results<T> error(int errorCode,String msg){
        CodeMsg codeMsg = CodeMsg.codeMsg(errorCode).fillArgs(msg);
        return new Results<T>(codeMsg);
    }




}
