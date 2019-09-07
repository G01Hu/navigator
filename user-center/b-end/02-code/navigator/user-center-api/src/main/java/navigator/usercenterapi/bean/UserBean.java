package navigator.usercenterapi.bean;

/**
 * @author:huqy
 * @ClassName: UserBean
 * @Description:
 * @date: 2019/8/20
 */
public class UserBean extends BaseBean{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6114660681332624158L;
    //主键
    private String id;
    //用户名
    private String userName;
    //密码
    private String password;
    //邮箱
    private String mail;
    //头像
    private String handPortrait;
    //状态
    private char flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHandPortrait() {
        return handPortrait;
    }

    public void setHandPortrait(String handPortrait) {
        this.handPortrait = handPortrait;
    }

    public char getFlag() {
        return flag;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }
}
