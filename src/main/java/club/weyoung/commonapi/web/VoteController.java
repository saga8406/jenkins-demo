///:VoteController.java
package club.weyoung.commonapi.web;

import club.weyoung.commonapi.common.JsonResult;
import club.weyoung.commonapi.vo.ActorVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author icechen1219
 * @date 2019/05/23
 */
@Api(tags = "模拟投票接口")
@RestController
public class VoteController {
    private Logger logger = LoggerFactory.getLogger(VoteController.class);
    private Integer state;
    private static Executor taskExecutor = taskExecutor();
    private Random rd=new Random();
    private ActorVo actorVo1;
    private ActorVo actorVo2;

    @ApiOperation("开启或关闭投票接口")
    @GetMapping("vote/start")
    public JsonResult startVotePk(@RequestParam("state") Integer state) {
        this.state = state;

        JsonResult result = new JsonResult();
        if (Integer.valueOf(1).equals(state)) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    logger.info("开始投票1...");
                    actorVo1 = new ActorVo();
                    actorVo1.setId(rd.nextInt(100));
                    actorVo1.setName("选手一");
                    while (VoteController.this.state.equals(1)) {
                        int voteCount = actorVo1.getVoteCount();
                        actorVo1.setVoteCount(voteCount + rd.nextInt(5));
                        try {
                            Thread.sleep(rd.nextInt(500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    logger.info("开始投票2...");
                    actorVo2 = new ActorVo();
                    actorVo2.setId(rd.nextInt(100));
                    actorVo2.setName("选手二");
                    while (VoteController.this.state.equals(1)) {
                        int voteCount = actorVo2.getVoteCount();
                        actorVo2.setVoteCount(voteCount + rd.nextInt(5));
                        try {
                            Thread.sleep(rd.nextInt(500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            result.setErrorCode(0);
            result.setErrorMsg("OK");
        } else {
            result.setErrorCode(-1);
            result.setErrorMsg("投票还未开启，请耐心等待...");
        }
        return result;
    }

    @ApiOperation("获得当前投票数据接口")
    @GetMapping("vote/pk")
    public List<ActorVo> getPkVotes() {
        if (Integer.valueOf(1).equals(state)) {
            return Arrays.asList(actorVo1, actorVo2);
        } else {
            return Collections.emptyList();
        }
    }

    private static Executor taskExecutor() {
        System.out.println("初始化模拟投票任务线程池...");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(30);
        executor.setThreadNamePrefix("asyncTaskExecutor-");
        executor.initialize();

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
///:VoteController.java
