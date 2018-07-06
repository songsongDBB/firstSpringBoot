package com.dss.girl.handle;

import com.dss.girl.Exception.GirlException;
import com.dss.girl.domain.Result;
import com.dss.girl.enums.ResultEnum;
import com.dss.girl.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常统一处理
 * 流程：在service里面出现异常，抛到Controller里面，Controller也不会处理，最后进入到这个类里面
 */
@RestControllerAdvice
public class ExceptionHandle {

    /**
     * 处理的异常名字是Exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){

        if(e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtil.retrunResult(girlException.getCode(), girlException.getMessage(), null);
        }else{
            return ResultUtil.retrunResult(ResultEnum.UNKNOW_ERROR.getCode(), ResultEnum.UNKNOW_ERROR.getMsg(),null);
        }
    }
}
