///:EasyUiTree.java
package club.weyoung.commonapi.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author icechen1219
 * @date 2019/05/21
 */
public class EasyUiTree implements Serializable {

    private Integer id;
    private String text;
    private String iconCls;
    private Attribute attributes;
    private Boolean checked;
    private String state;
    private List<EasyUiTree> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    public Boolean isChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<EasyUiTree> getChildren() {
        return children;
    }

    public void setChildren(List<EasyUiTree> children) {
        this.children = children;
    }
}
///:EasyUiTree.java
