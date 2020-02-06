///:FaceDetectController.java
package club.weyoung.commonapi.web;

import club.weyoung.commonapi.util.FaceApiUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author icechen1219
 * @date 2019/05/08
 */
@RestController
@RequestMapping("/api/face")
@Api(value = "face", tags = "人脸探测服务")
public class FaceDetectController {

    @ApiOperation("根据网络图片地址探测人脸数据")
    @PostMapping("/detectUrl")
    public Object guessEmotion1(String imageUrl) {
        return FaceApiUtil.faceDetectFromUrl(imageUrl);
    }

    @ApiOperation("上传本地图片的base64数据进行人脸数据探测")
    @PostMapping("/detectImage")
    public Object guessEmotion2(String imageBase64) {
        return FaceApiUtil.faceDetectFromImage(imageBase64);
    }

}
///:FaceDetectController.java
