package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.UserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {
    @Select("select * from users where username = #{username}")
    UserData findUserByName(String username);

    @Select("select * from users")
    List<UserData> findAllUsers();

    @Insert("insert into users (username,password,role) values(#{username},#{password},#{role})")
    int addUser(String username,String password,String role);
}
