package com.cxy890.boot2.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Created by BD-PC19 on 2017/7/6.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {

    private Integer status;

    private String msg;

    private Object data;

    public static Mono<CommonResult> build(Integer status, String msg, Object data) {
        return Mono.just(new CommonResult(status, msg, data));
    }

    public static Mono<CommonResult> ok(Object data) {
        return Mono.just(new CommonResult(200, null, data));
    }

    public static Mono<CommonResult> ok() {
        return Mono.just(new CommonResult(200, null, null));
    }

    public static Mono<CommonResult> error(Integer status, String msg) {
        return Mono.just(new CommonResult(status, msg, null));
    }

}
