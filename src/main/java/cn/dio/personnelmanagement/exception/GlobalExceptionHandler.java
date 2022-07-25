package cn.dio.personnelmanagement.exception;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public String handle5xxException(Exception e) {
        System.out.println("异常是："+e);

        return "error/5xx";
    }
}
