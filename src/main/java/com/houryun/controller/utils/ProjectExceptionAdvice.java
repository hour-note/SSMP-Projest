package com.houryun.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 统一异常处理

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public Result doException(Exception ex) {
        // 记录日志
        // 通知运维
        // 通知开发

        // 打印报错信息
        ex.printStackTrace();

        return new Result("服务器故障，请稍候再试！");
    }
}
