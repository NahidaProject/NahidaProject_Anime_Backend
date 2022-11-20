package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.UserData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users where username = #{username}")
    UserData findUserByName(String username);

    @Select("select * from users")
    List<UserData> findAllUsers();

    @Insert("insert into users (username,password,role) values(#{username},#{password},#{role})")
    int addUser(UserData userData);

    @Update("update users set username=#{username} ,password=#{password}, role=#{role} where id=#{id}")
    int updateUser(int id,String username,String password,String role);

    @Delete("delete from users where username = #{username}")
    int delUser(String username);
}
