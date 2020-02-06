///:SimpleTree.java
package club.weyoung.commonapi.vo;

import java.io.Serializable;

/**
 * @author icechen1219
 * @date 2019/05/21
 */
public class SimpleTree implements Serializable {
    private Integer id;
    private Integer pId;
    private String name;
    private Boolean open;
    private Boolean isParent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        isParent = parent;
    }
}
///:SimpleTree.java
