package club.weyoung.commonapi.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FaceApiUtil {
    private static final Logger logger = LoggerFactory.getLogger(FaceApiUtil.class);
    /**
     * json提取正则
     */
    private static final Pattern pattern = Pattern.compile("(\\[[\\s\\S]*\\])", Pattern.MULTILINE);

    /**
     * url正则表达式
     */
    private static final Pattern urlPattern = Pattern.compile("http[s]?://.+");

    /**
     * 图片base64正则
     */
    private static final Pattern base64Pattern = Pattern.compile("^data:image/\\w+?;base64.+");


    public static Object faceDetectFromImage(String base64) {
        if (!base64Pattern.matcher(base64).find()) {
            logger.error("网址不正确: {}", base64.substring(0, 20));
            throw new RuntimeException("不是正确的base64格式");
        }
        // Request body
        MultipartEntityBuilder meb = MultipartEntityBuilder.create();
        meb.addTextBody("__RequestVerificationToken", "jZ9N8W55jcEtS2Lk4_Iiysj393BhNJnG3zZpdjCr-fuUGNhrCq64GTER-7koINTez74eG2jJuqPOJHGzNuxD5mZ-pC01");
        meb.addTextBody("Image.Url", "");
        meb.addTextBody("Image.File", "");
        meb.addTextBody("Image.Base64Url", base64);
        meb.addTextBody("Image.DemoFile", "");

        return guessEmotionV2(meb);
    }

    public static Object faceDetectFromUrl(String imageUrl) {
        if (!urlPattern.matcher(imageUrl).find()) {
            logger.error("网址不正确: {}", imageUrl);
            throw new RuntimeException("网址不正确");
        }

        // Request body
        MultipartEntityBuilder meb = MultipartEntityBuilder.create();
        meb.addTextBody("__RequestVerificationToken", "jZ9N8W55jcEtS2Lk4_Iiysj393BhNJnG3zZpdjCr-fuUGNhrCq64GTER-7koINTez74eG2jJuqPOJHGzNuxD5mZ-pC01");
        meb.addTextBody("Image.Url", imageUrl);
        meb.addTextBody("Image.File", "");
        meb.addTextBody("Image.Base64Url", "");
        meb.addTextBody("Image.DemoFile", "");

        return guessEmotionV2(meb);
    }


    /**
     * 爬取微软认知服务演示功能的结果，不需要密钥
     *
     * @param requestBody
     * @return
     */
    private static Object guessEmotionV2(MultipartEntityBuilder requestBody) {
        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder("https://azure.microsoft.com/zh-cn/cognitive-services/demo/facedetectionapi/");

            URI uri = builder.build();
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
            httpPost.setHeader("Cookie",
                    "MC1=GUID=9df2c4349c8e45248e5a1b61e3ee2f66&HASH=9df2&LV=201802&V=4&LU=1518271625899; MUID=3CC55AA7D0B765551F3C5135D4B76353; MSFPC=ID=9df2c4349c8e45248e5a1b61e3ee2f66&CS=3&LV=201802&V=1; A=I&I=AxUFAAAAAACICgAAxZdzyEdMqOF494Sp+1YdYg!!&V=4; _ga=GA1.2.564558550.1523366513; userInfo={\"guid\":\"2a239694-1b09-4789-8330-b633ee70e619\"}; optimizelyEndUserId=oeu1525577721162r0.020832983941297734; optimizelySegments=%7B%226593856057%22%3A%22gc%22%2C%226592955995%22%3A%22none%22%2C%226598286065%22%3A%22false%22%2C%226600074341%22%3A%22referral%22%7D; optimizelyBuckets=%7B%7D; _ga=GA1.3.564558550.1523366513; ai_user=yOEuh|2018-05-06T03:35:33.662Z; MSFPC=GUID=9df2c4349c8e45248e5a1b61e3ee2f66&HASH=9df2&LV=201802&V=4&LU=1518271625899; mp_1d92e3abd14a2d65f748d1314dd24b99_mixpanel=%7B%22distinct_id%22%3A%20%221633384fa9d8ff-0bc7ecdcf8a64a-3c3c5905-100200-1633384fa9e18b%22%2C%22__alias%22%3A%20%222a239694-1b09-4789-8330-b633ee70e619%22%2C%22%24initial_referrer%22%3A%20%22https%3A%2F%2Fwww.jianshu.com%2Fp%2Fa410df8a0358%22%2C%22%24initial_referring_domain%22%3A%20%22www.jianshu.com%22%7D; _CT_RS_=Recording; WRUIDAWS=1754621259268383; hblid=C2dBVYLTOg8rTRcU7k89I0H67TEaFbyX; olfsk=olfsk8016150721219715; _gid=GA1.3.1297429818.1528431427; MS0=b70c88b765044d23a98d1a0f596f833d; __RequestVerificationToken=VBnOCCOukzl7N7YoyVqdQuDenjr9WBnH8MHakKbRGvsB1Zm8fsSBFQsc05XwV8b4iZ148GPq4NJduMLLmRbnrOmwGbE1; __CT_Data=gpv=70&ckp=tld&dm=microsoft.com&apv_38960_www02=70&cpv_38960_www02=70&rpv_38960_www02=18; ai_session=yJ4+W|1528510411087|1528510852557.3");
            httpPost.setHeader("Referer", "https://azure.microsoft.com/zh-cn/services/cognitive-services/face/");


            httpPost.setEntity(requestBody.build());

            HttpResponse clientResponse = httpclient.execute(httpPost);
            HttpEntity entity = clientResponse.getEntity();

            if (entity != null) {
                // entity所得到的流是不可重复读取的也就是说所得的到实体只能一次消耗完,不能多次读取
                String res = EntityUtils.toString(entity);
                logger.info(res);
                //因为示例网站得到的是一个html代码，所以需要用正则提取json数据

                Matcher matcher = pattern.matcher(res);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    logger.debug(group);
                    //将转义的引号还原
                    return JSON.parse(group.replaceAll("&quot;", "\""));
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static void main(String[] args) {
        Object res = faceDetectFromUrl("http://img5.mtime.cn/pi/2018/03/09/075949.98135100_1000X1000.jpg");
//		Object res = faceDetectFromUrl("https://loveboyin.cn/upload/20180607/A%E9%87%91%E7%A7%91%E5%B0%8F%E7%A8%8B15123380357%F0%9F%8D%83_1528341076328.jpg");

        logger.info(res.toString());

    }

}
