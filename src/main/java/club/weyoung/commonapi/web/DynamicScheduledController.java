///:DynamicScheduledController.java
package club.weyoung.commonapi.web;

import club.weyoung.commonapi.service.ScheduledForDynamicCron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author icechen1219
 * @date 2019/05/23
 */
@RestController
@RequestMapping("/dynamic-scheduled")
public class DynamicScheduledController {


    @Autowired
    ScheduledForDynamicCron scheduledForDynamicCron;

    @RequestMapping(value = "/update-cron")
    public String updateDynamicScheduledTask(@RequestParam("cron") String cron) {

        scheduledForDynamicCron.setCron(cron);

        return "success";
    }
}
///:DynamicScheduledController.java
