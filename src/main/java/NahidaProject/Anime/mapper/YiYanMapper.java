package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.YiYanData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YiYanMapper {
    @Select("SELECT * FROM yiyan")
    List<YiYanData> GetAllYiYan();
    @Select("SELECT * FROM yiyan ORDER BY RAND() LIMIT 1;")
    YiYanData Random();

    @Insert("INSERT into yiyan(YiYanID,AdminID,Sentence,Origin) values(#{YiYanID},#{AdminID},#{Sentence},#{Origin})")
    int NewYiYan(YiYanData yiyanData);
}
