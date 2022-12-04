package com.minikode.webflux_demo.annotation

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
annotation class CheckTimer()

@Component
@Aspect
class CheckTimerConfig {

    @Pointcut("@annotation(CheckTimer)")
    fun checkTimer() {
    }

    @Around("checkTimer()")
    fun execute(proceedingJoinPoint: ProceedingJoinPoint) {
        val methodSignature = proceedingJoinPoint.signature as MethodSignature
        val stopWatch = StopWatch()
        stopWatch.start()
        proceedingJoinPoint.proceed()
        stopWatch.stop()
        println("메소드 이름: ${methodSignature.method.name}\n걸린시간: ${stopWatch.totalTimeMillis}")
    }

}