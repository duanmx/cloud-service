package com.duan.commmon.exception;
import com.duan.commmon.core.Results;
import com.duan.commmon.core.constants.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author duanmx
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {



    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Results<Void> handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}", e.getMessage(), e.getClass());
        StringBuilder stringBuilder = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            stringBuilder.append(errorMessage);
            stringBuilder.append("!");
        });
        return Results.error(CommonConstants.RESULT_PARAMETER_VALIDATOR, stringBuilder.toString());
    }


    @ExceptionHandler(value = Exception.class)
    public Results<Void> exceptionHandler(Exception e) {
        log.error("异常信息," + e.getMessage(), e);
        if (e instanceof GlobalException) {
            //自定义异常
            GlobalException ex = (GlobalException) e;
            Results<Void> results = Results.error(CommonConstants.RESULT_PARAMETER_VALIDATOR);
            results.setMsg(ex.getCm().getMsg());
            results.setError(ExceptionUtils.getStackTrace(ex));
            return results;
        }  else {
            //其他异常
            Results<Void> results = Results.error(CommonConstants.RESULT_SERVER_ERROR);
            results.setError(ExceptionUtils.getStackTrace(e));
            return results;
        }
    }


}
