package com.duan.commmon.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author duanmx
 * @since 2021/7/14
 */
public class ExceptionUtils {

    /**
     * 获取完整的异常堆栈信息
     * @param throwable throwable
     * @return String
     */
    public   static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }
}
