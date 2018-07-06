package com.dss.girl.utils;

import com.dss.girl.domain.Result;

public class ResultUtil {

    public static Result retrunResult(Integer code, String msg, Object object){

        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);

        return result;
    }
}
