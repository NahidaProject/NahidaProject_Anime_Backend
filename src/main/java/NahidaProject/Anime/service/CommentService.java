package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.CommentData;
import NahidaProject.Anime.mapper.CommentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Resource
    CommentMapper commentMapper;
    @Resource
    UserService userService;
    public List<CommentData> GetCommentsByAnimeID(String AnimeID){
        return commentMapper.GetCommentsByAnimeID(AnimeID);
    }

    public void AddCommentByAnimeID(CommentData commentData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        commentData.setCommentID(GetLatestID());
//        通过用户账号获取用户ID(前端返回的用户名实际是就是用户账号)
        commentData.setUserID(userService.GetUserIDByUserAccount(commentData.getUserName()));
        commentData.setCommentDate(simpleDateFormat.format(date));
        commentMapper.AddCommentByAnimeID(commentData);
    }

    public int GetLatestID() {
        return commentMapper.GetAllComments().size()+1;
    }
}
