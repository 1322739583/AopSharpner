package com.example.networkcheckaop.aop.anotation;

import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.NetworkUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NetworkCheckAop {
    Context context;

    @Pointcut("execution(@com.example.networkcheckaop.aop.anotation.NetworkCheck * *(..))")
    public void beforLoad(){ }

    @Around("beforLoad()")
    public Object proccedPointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object thisObj = proceedingJoinPoint.getThis();
        Object result=null;
        if (thisObj instanceof Context){
            this.context= (Context) thisObj;
        }else if (thisObj instanceof Fragment){
            this.context=((Fragment) thisObj).getActivity();
        }

        if (null==context){
            throw new NullPointerException("Context is null");
        }




        if (NetworkUtils.isConnected()){
            result = proceedingJoinPoint.proceed();
        }else {
            Toast.makeText(context, "没有网络", Toast.LENGTH_SHORT).show();
        }
        return result;
    }
}
