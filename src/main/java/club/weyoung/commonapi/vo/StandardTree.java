///:StandardTree.java
package club.weyoung.commonapi.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author icechen1219
 * @date 2019/05/21
 */
public class StandardTree implements Serializable {
    private Integer id;
    private String name;
    private Boolean open;
    private Boolean isParent;
    private List<StandardTree> children;

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

    public List<StandardTree> getChildren() {
        return children;
    }

    public void setChildren(List<StandardTree> children) {
        this.children = children;
    }
}
///:StandardTree.java
