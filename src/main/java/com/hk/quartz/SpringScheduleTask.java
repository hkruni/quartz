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
//public class SpringScheduleTask {
//
//    private  final Logger logger = LoggerFactory.getLogger(SpringScheduleTask.class);
//
//    /**
//     *  每分钟执行一次
//     */
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void reptilian(){
//        logger.info("执行调度任务："+ Thread.currentThread().getName() + ":" + new Date());
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}