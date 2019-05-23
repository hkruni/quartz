package com.hk.quartz;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 配置任务
 */
@Configuration
public class QuartzConfiguration {

    /**
     *  配置任务1
     * @param quartzTask QuartzTask为需要执行的任务
     * @return
     */
    @Bean(name = "reptilianJob1")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(QuartzTask quartzTask) {

        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

        // 是否并发执行,例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了，
        //如果此处为true，则下一个任务会bing执行，
        // 如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行
        jobDetail.setConcurrent(false);
        // 设置任务的名字
        jobDetail.setName("reptilianJob1");
        // 设置任务的分组，在多任务的时候使用
        jobDetail.setGroup("reptilianJobGroup");
        // 需要执行的对象
        jobDetail.setTargetObject(quartzTask);
         //执行QuartzTask类中的需要执行方法
        jobDetail.setTargetMethod("reptilian1");

        return jobDetail;
    }

    /**
     * 定时触发器1
     * @param reptilianJob 任务
     * @return
     */
    @Bean(name = "jobTrigger1")
    public CronTriggerFactoryBean cronJobTrigger(JobDetail reptilianJob1){

        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();

        tigger.setJobDetail(reptilianJob1);

        //cron表达式，每1分钟执行一次
        tigger.setCronExpression("0/3 * * * * ?");
        tigger.setName("reptilianTrigger1");
        return tigger;
    }



    /**
     *  配置任务1
     * @param quartzTask QuartzTask为需要执行的任务
     * @return
     */
    @Bean(name = "reptilianJob2")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean2(QuartzTask2 quartzTask) {

        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

        // 是否并发执行
        jobDetail.setConcurrent(false);
        // 设置任务的名字
        jobDetail.setName("reptilianJob2");
        // 设置任务的分组，在多任务的时候使用
        jobDetail.setGroup("reptilianJobGroup");
        // 需要执行的对象
        jobDetail.setTargetObject(quartzTask);
        //执行QuartzTask类中的需要执行方法
        jobDetail.setTargetMethod("reptilian2");

        return jobDetail;
    }

    /**
     * 定时触发器1
     * @param reptilianJob1 任务
     * @return
     */
    @Bean(name = "jobTrigger2")
    public CronTriggerFactoryBean cronJobTrigger2(JobDetail reptilianJob2){

        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();

        tigger.setJobDetail(reptilianJob2);

        //cron表达式，每1分钟执行一次
        tigger.setCronExpression("0/5 * * * * ?");
        tigger.setName("reptilianTrigger2");
        return tigger;
    }


    /**
     * 调度工厂1
     * @param jobTrigger1 触发器
     * @return
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger jobTrigger1,Trigger jobTrigger2) {

        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);
        // 延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);
        // 注册触发器
        factoryBean.setTriggers(jobTrigger1,jobTrigger2);
        return factoryBean;
    }


}

