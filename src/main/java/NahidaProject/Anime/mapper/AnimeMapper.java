package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.AnimeData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnimeMapper {
    @Select("select * from anime")
    List<AnimeData> findAllAnime();

    @Select("select * from anime where a_id=#{a_id}")
    AnimeData findAnimeById(String a_id);

    @Insert("insert into anime values (#{a_id},#{a_name},#{a_release_date},#{a_company},#{a_set},#{a_type},#{a_desc},#{a_hot},#{a_cv},#{a_stats},#{a_lang},#{a_recommend})")
    int addAnime(AnimeData animeData);

    @Update("update anime set a_id=#{a_id},a_name=#{a_name},a_release_date=#{a_release_date},a_company=#{a_company},a_set=#{a_set}," +
            "a_type=#{a_type},a_desc=#{a_desc},a_hot=#{a_hot},a_cv=#{a_cv},a_stats=#{a_stats},a_lang=#{a_lang},a_recommend=#{a_recommend} where id=#{id}")
    int updateAnime(AnimeData animeData);

    @Delete("delete from anime where a_id = #{a_id}")
    int deleteAnime(String a_id);
}
