package com.yutu.exception;

import com.yutu.entity.MsgPack;
import com.yutu.entity.MsgStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhaobc
 * @Date: 2020/11/10 17:30
 * @Description:
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public MsgPack bizExceptionHandler(HttpServletRequest req, BizException e){
        logger.error("发生业务异常！原因是：",e.getErrorMsg());
        return new MsgPack(MsgStatus.FAIL,"发生业务异常",e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public MsgPack exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return new MsgPack(MsgStatus.FAIL,"发生空指针异常",ErrorEnum.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public MsgPack exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return  new MsgPack(MsgStatus.FAIL,"发生未知异常",ErrorEnum.INTERNAL_SERVER_ERROR);
    }
}
