///:ScheduledForDynamicCron.java
package club.weyoung.commonapi.service;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author icechen1219
 * @date 2019/05/23
 */
@Service
public class ScheduledForDynamicCron implements SchedulingConfigurer {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 秒 分 时 每月第几天 月 星期 年
     */
    private static final String DEFAULT_CRON = "0/5 * * * * ?";
    private String cron = DEFAULT_CRON;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            // 定时任务的业务逻辑
            System.out.println("动态修改定时任务cron参数，当前时间：" + dateFormat.format(new Date()));
        }, (triggerContext) -> {
            // 定时任务触发，可修改定时任务的执行周期
            CronTrigger trigger = new CronTrigger(cron);
            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
            return nextExecDate;
        });
    }

    public void setCron(String cron) {
        System.out.println("当前cron=" + this.cron + "->将被改变为：" + cron);
        this.cron = cron;
    }

}
///:ScheduledForDynamicCron.java
