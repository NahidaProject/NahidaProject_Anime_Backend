package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.AdminData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("call admin_login(#{acc})")
    String AdminLoginByAccount(String acc);

    @Insert("insert into admin(AdminName,AdminAccount,AdminPassword) values(#{AdminName},#{AdminAccount},#{AdminPassword})")
    int AdminRegister(AdminData adminData);

    @Select("select AdminName from admin where AdminAccount = #{acc}")
    String GetAdminNameByAccount(String acc);

    @Select("select AdminID from admin where AdminAccount = #{acc}")
    int GetAdminIDByAccount(String acc);
}
