package com.lanxin.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//无参
@AllArgsConstructor//所有参构造
public class Result {
    private Integer code;
    private String msg;
    private Object data;//数据

    private Integer sum;//总条数

    public Result(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public Result(Integer code, String msg, Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public static Result ok() {
        return new Result(200, "操作成功");
    }

    public static Result ok(Object obj) {
        return new Result(200, "操作成功", obj);
    }

    public static Result ok(Object obj, Integer sum) {
        return new Result(200, "操作成功", obj,sum);
    }


    public static Result flat(Integer code,String msg){
        return new Result(code,msg);
    }
}
