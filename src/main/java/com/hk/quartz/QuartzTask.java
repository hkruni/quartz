package com.hk.quartz;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 使用quartz框架
 */
@Service
public class QuartzTask {

    /**
     * 业务逻辑
     */
    public void reptilian1(){
        System.out.println(Thread.currentThread().getName() + "执行业务处理逻辑1："+new Date());
    }
}
