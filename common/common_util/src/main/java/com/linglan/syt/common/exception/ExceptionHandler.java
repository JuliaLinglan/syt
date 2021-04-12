package com.linglan.syt.common.exception;

import com.linglan.syt.common.result.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({BusinessException.class})
    @ResponseBody
    public Response handleBusinessException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        String uri = request.getRequestURI();
        BaseException e = (BaseException) ex;
        long code = e.getErrcode();
        String msg = e.getMsg();
        log.error("接口:{}, 发生业务异常", uri,  e);
        return Response.failed(code, msg);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AuthException.class)
    @ResponseBody
    public Response handleAuthException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        String uri = request.getRequestURI();
        BaseException e = (BaseException) ex;
        long code = e.getErrcode();
        String msg = e.getMsg();
        log.error("caught error api:{}, code:{}, msg:{}", uri, code, msg);
        if (e.getException() != null) {
            log.error("caught error api:{}, error info", e.getException());
        }
        response.setStatus(403);
        return Response.failed(code, msg);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(Model model, HttpServletRequest request, HttpServletResponse response, Exception e) {
        String uri = request.getRequestURI();
        log.error("接口:{}, 发生系统异常", uri,  e);
        return Response.failed();
    }
}
