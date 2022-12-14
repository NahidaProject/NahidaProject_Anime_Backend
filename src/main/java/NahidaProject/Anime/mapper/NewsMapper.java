package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.NewsData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Select("select * from news")
    List<NewsData> GetAllNews();
    @Select("select NewsContent from news where NewsID=#{NewsID}")
    String GetNewsContentByID(int NewsID);

    @Insert("insert into news(NewsID,NewsTitle,NewsCategory,NewsAuthor,NewsDate,NewsViewCount,NewsContent) values(#{NewsID},#{NewsTitle},#{NewsCategory},#{NewsAuthor},#{NewsDate},#{NewsViewCount},#{NewsContent})")
    int NewNews(NewsData newsData);

    @Update("update news set NewsTitle=#{NewsTitle},NewsCategory=#{NewsCategory},NewsAuthor=#{NewsAuthor},NewsDate=#{NewsDate},NewsViewCount=#{NewsViewCount},NewsContent=#{NewsContent} where NewsID=#{NewsID}")
    int UpdateNews(NewsData newsData);

    @Delete("delete from news where NewsID=#{NewsID}")
    void DeleteNews(int NewsID);

    @Select("SELECT * FROM news WHERE news.NewsTitle LIKE CONCAT('%',#{NewsTitleLike},'%')")
    List<NewsData> FindNewsLike(String NewsTitleLike);
}
