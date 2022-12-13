package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.NewsData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Select("select * from news")
    List<NewsData> GetAllNews();
}
