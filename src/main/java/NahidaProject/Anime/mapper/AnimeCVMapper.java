package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.AnimeCVData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnimeCVMapper {
    @Insert("insert into animecv(CVID,CVName) value(#{CVID},#{CVName})")
    void AddCV(AnimeCVData animeCVData);

    @Select("select * from animecv")
    List<AnimeCVData> GetAllAnimeCV();

    @Delete("delete from animecv where CVName=#{CVName}")
    void DeleteCV(String cvName);
}
