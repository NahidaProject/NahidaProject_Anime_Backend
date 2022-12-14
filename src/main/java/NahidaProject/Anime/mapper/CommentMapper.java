package NahidaProject.Anime.mapper;

import NahidaProject.Anime.entity.CommentData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("call findcomments(#{AnimeID})")
    List<CommentData> GetCommentsByAnimeID(String AnimeID);
    @Select("select * from comment")
    List<CommentData> GetAllComments();
    @Insert("insert into comment(CommentID,CommentDate,CommentText,UserID,AnimeID) VALUES(#{CommentID},#{CommentDate},#{CommentText},#{UserID},#{AnimeID})")
    void AddCommentByAnimeID(CommentData composite);
}
