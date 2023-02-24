package com.houryun.controller.utils;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Object data;
    private String msg;

    public Result(Object data) {
        this.data = data;
    }

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public Result(String msg) {
        this.msg = msg;
    }
}
