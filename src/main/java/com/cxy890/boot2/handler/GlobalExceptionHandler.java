package com.cxy890.boot2.handler;

import com.cxy890.boot2.common.CommonResult;
import com.cxy890.boot2.common.constant.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 * 异常统一处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public Mono<CommonResult> jsonErrorHandler(ServerHttpRequest req, Exception e) {
        log.error("error：", e);
        return CommonResult.error(Const.SERVER_ERROR_CODE, e.getMessage());
    }

}
