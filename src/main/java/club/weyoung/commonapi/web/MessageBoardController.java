///:MessageBoardController.java
package club.weyoung.commonapi.web;

import club.weyoung.commonapi.common.JsonResult;
import club.weyoung.commonapi.vo.MessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author icechen1219
 * @date 2019/05/12
 */
@RestController
@Api(value = "message", tags = "留言板服务")
public class MessageBoardController {
    private static Map<String, MessageVo> msgMap = new HashMap<>();

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @ApiOperation("创建留言")
    @PostMapping("/message")
    public JsonResult addMessage(MessageVo messageVo) {
        logger.info(messageVo.toString());

        JsonResult result = new JsonResult();

        messageVo.setId(msgMap.size() + 1L);
        messageVo.setGmtCreate(new Date());
        String key = messageVo.getTitle() + messageVo.getDetail();
        // 如果标题和正文重复，只保留第一项
        if (!msgMap.containsKey(key)) {
            msgMap.put(key, messageVo);
            result.setErrorCode(0);
        } else {
            result.setErrorCode(0x1113);
            result.setErrorMsg("请不要重复发帖！");
        }

        return result;
    }

    @ApiOperation("根据id查询留言明细")
    @GetMapping("/message/{id}")
    public JsonResult getMessage(@PathVariable Long id) {
        JsonResult result = new JsonResult();
        msgMap.values().forEach(msg -> {
            if (msg.getId().equals(id)) {
                result.setData(msg);
                result.setErrorCode(0);
            }
        });
        if (result.getErrorCode() == null) {
            result.setErrorCode(0x1114);
            result.setErrorMsg("没有对应的数据！");
        }
        return result;
    }

    @ApiOperation("查询所有留言")
    @GetMapping("/messages")
    public JsonResult getAllMessages() {
        JsonResult result = new JsonResult();
        List<Object> list = msgMap.values().stream().map(msg -> {
            MessageVo tmp = new MessageVo();
            tmp.setId(msg.getId());
            tmp.setName(msg.getName());
            tmp.setEmail(msg.getEmail());
            tmp.setPhone(msg.getPhone());
            tmp.setTitle(msg.getTitle());
            return tmp;
        }).collect(Collectors.toList());

        result.setData(list);
        result.setErrorCode(0);
        return result;
    }
}
///:MessageBoardController.java
