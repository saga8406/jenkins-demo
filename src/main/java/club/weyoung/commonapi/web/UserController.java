///:UserController.java
package club.weyoung.commonapi.web;

import club.weyoung.commonapi.common.JsonResult;
import club.weyoung.commonapi.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author icechen1219
 * @date 2019/05/12
 */
@RestController
@Api(tags = "用户管理")
public class UserController {
    private static Map<String, UserVo> dataMap = new HashMap<>();

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("创建用户")
    @PostMapping("/register")
    public JsonResult register(UserVo userVo) {
        logger.info(userVo.toString());
        JsonResult result = new JsonResult();
        if (dataMap.containsKey(userVo.getUsername())) {
            result.setErrorCode(0x1111);
            result.setErrorMsg("用户名被占用！");
            return result;
        }

        userVo.setId(dataMap.size() + 1);
        userVo.setGmtCreate(new Date());
        userVo.setState(1);
        dataMap.put(userVo.getUsername(), userVo);

        result.setData(userVo);
        result.setErrorCode(0);
        return result;
    }

    @ApiOperation("检测用户名是否重复")
    @GetMapping("/user/{username}")
    public JsonResult checkUsername(@PathVariable String username) {
        logger.info(dataMap.toString());
        JsonResult result = new JsonResult();
        if (dataMap.containsKey(username)) {
            result.setErrorCode(0x1111);
            result.setErrorMsg("用户名被占用！");
        } else {
            result.setErrorCode(0);
        }

        return result;
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public JsonResult login(@RequestBody UserVo userVo) {
        JsonResult result = new JsonResult();
        UserVo param = dataMap.get(userVo.getUsername());
        if (param != null && param.getPassword().equals(userVo.getPassword())) {
            result.setErrorCode(0);
        } else {
            result.setErrorCode(0x1112);
            result.setErrorMsg("用户名或密码错误！");
        }
        return result;
    }

    @ApiOperation("用户列表")
    @GetMapping("/users")
    public JsonResult getAllUsers() {
        JsonResult result = new JsonResult();
        result.setData(dataMap.values());
        result.setErrorCode(0);
        return result;
    }

}
///:UserController.java
