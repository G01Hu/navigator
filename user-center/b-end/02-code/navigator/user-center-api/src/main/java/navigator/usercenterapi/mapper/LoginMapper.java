package navigator.usercenterapi.mapper;

import navigator.usercenterapi.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author :huqy
 * @ClassName: LoginMapper
 * @Description:
 * @date: 2019/8/19
 */
@Mapper
public interface LoginMapper {

    @Select("select * from user")
    UserBean test();

    @Select("SELECT id,\n" +
            "       user_name,\n" +
            "       password,\n" +
            "       mail,\n" +
            "       hand_portrait,\n" +
            "       flag,\n" +
            "       creator,\n" +
            "       create_date,\n" +
            "       reviser,\n" +
            "       update_date\n" +
            "from user WHERE user_name=#{userName}")
    UserBean getUser(UserBean userBean);
}
