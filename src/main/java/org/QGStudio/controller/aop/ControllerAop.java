package org.QGStudio.controller.aop;

import org.QGStudio.dtos.ResultBean;
import org.QGStudio.exception.CheckException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Description : 异常统一处理器
 * @Param :
 * @Return :
 * @Author : SheldonPeng
 * @Date : 2019-08-05
 */
@Aspect
@Component
public class ControllerAop {


    @Around("execution(public org.QGStudio.dtos.ResultBean org.QGStudio.controller..*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;

        try {
            result = (ResultBean<?>) pjp.proceed();
            System.out.println("切面");

        } catch (Throwable e) {

            System.out.println("进入异常");
            result = handlerException(pjp, e);

        }

        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();

        // 已知异常
        if (e instanceof CheckException) {

            System.out.println("处理异常");
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        } else if (e instanceof NullPointerException){

            result.setMsg("参数异常");
            result.setCode(ResultBean.FAIL);
        } else {
            //TODO 未知的异常，应该格外注意，可以发送邮件通知等
            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);
        }
        return result;
    }

}
