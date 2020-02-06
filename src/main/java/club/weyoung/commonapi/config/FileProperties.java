///:FileProperties.java
package club.weyoung.commonapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author icechen1219
 * @date 2019/05/15
 */
@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
///:FileProperties.java
