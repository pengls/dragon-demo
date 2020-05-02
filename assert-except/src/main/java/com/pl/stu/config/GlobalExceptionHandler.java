package com.pl.stu.config;

import com.pl.stu.exception.BaseException;
import com.pl.stu.model.Response;
import com.pl.stu.model.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandler
 * @Author pengl
 * @Date 2019-05-30 10:15
 * @Description 全局异常处理
 * @Version 1.0
 */
@ControllerAdvice
@ConditionalOnWebApplication
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Response busErrorException(BaseException e) {
        return Response.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Response handleBindException(BindException e) {
        return wrapperBindingResult(e.getBindingResult());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response handleValidException(MethodArgumentNotValidException e) {
        return wrapperBindingResult(e.getBindingResult());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exceptionHandler(HttpServletRequest request, Exception ex) {
        log.error("GlobalException Catch Exception ：{}", ex.getMessage(), ex);
        return Response.error(ResponseEnum.SYSTEM_ERROR.getCode(), ResponseEnum.SYSTEM_ERROR.getMsg());
    }

    private Response wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();

        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(": ");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());

        }

        return Response.error(ResponseEnum.VALID_ERROR.getCode(), msg.substring(2));
    }
}
