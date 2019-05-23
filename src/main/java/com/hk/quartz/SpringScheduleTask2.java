//package com.hk.quartz;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * spring自带任务框架，有弊端
// */
//@Component
//
//public class SpringScheduleTask2 {
//
//    private  final Logger logger = LoggerFactory.getLogger(SpringScheduleTask2.class);
//
//    /**
//     *  每分钟执行一次
//     */
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void reptilian(){
//        logger.info("执行调度任务222："+ Thread.currentThread().getName() + ":" + new Date());
//    }
//}