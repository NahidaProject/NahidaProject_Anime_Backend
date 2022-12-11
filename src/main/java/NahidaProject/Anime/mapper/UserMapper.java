package NahidaProject.Anime.mapper;
import NahidaProject.Anime.entity.UserData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<UserData> GetUsersList();

    @Insert("insert into user value(#{UserID},#{UserName},#{UserAccount},#{UserEmail},#{UserPassword},#{UserRegisterDate},#{UserDescription},#{UserGender})")
    int NewUser(UserData userData);

    @Delete("delete from user where UserID = #{UserID}")
    void DeleteUser(int UserID);

    @Update("update user set UserAccount=#{UserAccount},UserName=#{UserName},UserEmail=#{UserEmail},UserPassword=#{UserPassword},UserDescription=#{UserDescription},UserGender=#{UserGender},UserRegisterDate=#{UserRegisterDate} where UserID=#{UserID}")
    int UpdateUser(UserData userData);

    @Select("select UserPassword from user where UserAccount=#{UserAccount}")
    String GetUserPassword(UserData userData);

    @Select("select UserName from user where UserAccount=#{UserAccount}")
    String GetUserName(UserData userData);

    @Select("select UserName from user where UserEmail=#{UserEmail}")
    String GetUserNameByUserEmail(UserData userData);

    @Select("select * from user where UserAccount=#{UserAccount}")
    UserData GetUserByUserAccount(UserData userData);
}
