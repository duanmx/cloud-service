package com.duan.commmon.core.constants;

/**
 * @author duanmx
 * @since 2021/6/29
 */
public class CommonConstants {
    /**
     * 成功
     */
    public static final int RESULT_SUCCESS = 0;

    /**
     * 服务器错误
     */
    public static final int RESULT_SERVER_ERROR=1;

    /**
     * 操作失败
     */
    public static final int RESULT_OPERATION_FAILED=2;
    /**
     * token错误或过期
     */
    public static final int RESULT_TOKEN_ERROR=3;
    /**
     * 无权限操作
     */
    public static final int RESULT_NO_JURISDICTION=4;
    /**
     * 参数校验异常
     */
    public static final int RESULT_PARAMETER_VALIDATOR=5;
    /**
     *  超级管理员角色
     */
    public static final String SUPER_ADMIN = "superAdmin";

    /**
     * pc端
     */
    public static final int SOURCE_PC = 0;
    /**
     * 移动端
     */
    public static final int SOURCE_MOBILE = 0;

    /**
     * 移动端具体类型 android端
     */
    public static final int SOURCE_MOBILE_ANDROID = 0;
    /**
     * 移动端具体类型 IOS端
     */
    public static final int SOURCE_MOBILE_IOS = 1;
    /**
     * 移动端具体类型 其他端
     */
    public static final int SOURCE_MOBILE_OTHER = 2;

}
