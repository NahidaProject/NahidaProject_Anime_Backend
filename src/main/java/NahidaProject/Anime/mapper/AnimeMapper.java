package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.AnimeData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnimeMapper {
    @Select("call findallanimes()")
    List<AnimeData> GetAllAnimes();

    @Select("call findanimebyid(#{aid})")
    AnimeData GetAnimeByID(int aid);

    @Insert("insert into anime(AnimeID,AnimeName,AnimeHot,AnimeDescription,AnimeLanguage,AnimeStats,AnimeCompany,AnimeEpisode,AnimeReleaseDate,AnimeRecommend) values(#{AnimeID},#{AnimeName},#{AnimeHot},#{AnimeDescription},#{AnimeLanguage},#{AnimeStats},#{AnimeCompany},#{AnimeEpisode},#{AnimeReleaseDate},#{AnimeRecommend})")
    int NewAnime(AnimeData animeData);

    @Update("update anime set AnimeName = #{AnimeName}, AnimeHot = #{AnimeHot}, AnimeDescription = #{AnimeDescription}, AnimeLanguage =#{AnimeLanguage}, AnimeStats = #{AnimeStats}, AnimeCompany = #{AnimeCompany}, AnimeEpisode = #{AnimeEpisode}, AnimeReleaseDate = #{AnimeReleaseDate}, AnimeRecommend = #{AnimeRecommend} where AnimeID = #{AnimeID}")
    int UpdateAnime(AnimeData AnimeData);

    @Update("call updatecv(#{CVName},#{AnimeID})")
    void UpdateCV(String CVName,int AnimeID);

    @Update("call updatetype(#{AnimeType},#{AnimeID})")
    void UpdateType(String AnimeType, int AnimeID);

    @Delete("delete from anime where AnimeID = #{AnimeID}")
    void DeleteAnime(int AnimeID);

    @Delete("delete from cv2anime where AnimeID = #{AnimeID}")
    void DeleteAllCVs(int AnimeID);

    @Delete("delete from type2anime where AnimeID = #{AnimeID}")
    void DeleteAllTypes(int AnimeID);
}
