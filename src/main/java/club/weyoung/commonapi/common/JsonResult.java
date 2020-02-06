///:JsonResult.java
package club.weyoung.commonapi.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author icechen1219
 * @date 2019/02/04
 */

@ApiModel("统一返回数据格式")
public class JsonResult implements Serializable {
    private String sessionId;
    @ApiModelProperty("错误码：为0表示没有错误，其他值均表示有错")
    private Integer errorCode;
    @ApiModelProperty("错误文字信息")
    private String errorMsg;
    @ApiModelProperty("结果集中的待处理数据")
    private Object data;
    @ApiModelProperty("数据总条数，用于分页")
    private int count;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        if (this.errorCode == 0) {
            this.setErrorMsg("OK");
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "sessionId='" + sessionId + '\'' +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
///:JsonResult.java
