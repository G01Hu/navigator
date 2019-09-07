package navigator.usercenterapi.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author:huqy
 * @ClassName: BaseBean
 * @Description:
 * @date: 2019/8/20
 */
public class BaseBean implements Serializable{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3567650048929084855L;

    //创建人
    private String creator;
    //创建时间
    private LocalDateTime createDate;
    //修改人
    private String reviser;
    //修改时间
    private LocalDateTime updateDate;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getReviser() {
        return reviser;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
