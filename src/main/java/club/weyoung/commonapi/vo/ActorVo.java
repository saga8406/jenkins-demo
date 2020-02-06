///:ActorVo.java
package club.weyoung.commonapi.vo;

import java.io.Serializable;

/**
 * @author icechen1219
 * @date 2019/05/23
 */
public class ActorVo implements Serializable {
    private Integer id;
    private String name;
    private int voteCount;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
///:ActorVo.java
