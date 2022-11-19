package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.YiyanData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YiyanMapper {
    @Select("SELECT * FROM yiyan")
    List<YiyanData> getAllYiyan();
    @Select("SELECT * FROM yiyan ORDER BY RAND() LIMIT 1;")
    YiyanData random();

    @Insert("INSERT into yiyan values(#{yiyan},#{fromwhere})")
    int addYiyan(YiyanData yiyanData);
}
