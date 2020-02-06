///:MessageVo.java
package club.weyoung.commonapi.vo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author icechen1219
 * @date 2019/05/12
 */
@ApiModel("消息对象")
public class MessageVo implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String title;
    private String detail;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageVo messageVo = (MessageVo) o;

        if (id != null ? !id.equals(messageVo.id) : messageVo.id != null) return false;
        if (name != null ? !name.equals(messageVo.name) : messageVo.name != null) return false;
        if (email != null ? !email.equals(messageVo.email) : messageVo.email != null) return false;
        if (phone != null ? !phone.equals(messageVo.phone) : messageVo.phone != null) return false;
        if (title != null ? !title.equals(messageVo.title) : messageVo.title != null) return false;
        if (detail != null ? !detail.equals(messageVo.detail) : messageVo.detail != null) return false;
        if (gmtCreate != null ? !gmtCreate.equals(messageVo.gmtCreate) : messageVo.gmtCreate != null) return false;
        return gmtModified != null ? gmtModified.equals(messageVo.gmtModified) : messageVo.gmtModified == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
///:MessageVo.java
