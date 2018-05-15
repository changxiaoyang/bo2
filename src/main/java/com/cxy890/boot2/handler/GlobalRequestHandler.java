package com.cxy890.boot2.handler;

import com.cxy890.boot2.common.CommonResult;
import com.cxy890.boot2.common.annotation.AopPoint;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class GlobalRequestHandler {

    /**
     * 定义切点，对 @AopPoint 标记的方法拦截
     */
    @Pointcut("(@annotation(com.cxy890.boot2.common.annotation.AopPoint))")
    public void methodPointcut(){}

    /**
     * 拦截器具体实现
     *
     * @param pjp ProceedingJoinPoint
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("methodPointcut()")
    public Object methodHandler(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        AopPoint aopPoint = method.getAnnotation(AopPoint.class);
        Object result;
//        SimpleStopWatch watch = new SimpleStopWatch(true);
//        if (aopPoint.cache() > 0) {
//            String key = buildKey(method, pjp.getArgs());
//            if ((result = SimpleCachePool.get(key)) == null) {
//                result = pjp.proceed();
//                SimpleCachePool.put(key, result, aopPoint.cache());
//            }
//        } else {
            result = pjp.proceed();
//        }
//        if (aopPoint.tmr())
//            log.debug(String.format("执行方法[%s]耗时：%s ms", method.getName(), watch.issueAndReset()));
//        if (AopPoint.Type.SERVICE.equals(aopPoint.type()) || result instanceof CommonResult)
//            return result;

        return CommonResult.ok(result);
    }

    private String buildKey(Method method, Object... args) {
        StringBuilder key = new StringBuilder(method.getName());
        for (Object parameter : args) {
            key.append(parameter == null ? ":null:" : parameter.toString());
        }
        return key.toString();
    }

}