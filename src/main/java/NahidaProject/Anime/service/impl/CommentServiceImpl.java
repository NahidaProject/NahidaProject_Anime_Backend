package NahidaProject.Anime.service.impl;

import NahidaProject.Anime.entity.CommentData;
import NahidaProject.Anime.mapper.CommentMapper;
import NahidaProject.Anime.service.CommentService;
import NahidaProject.Anime.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;
    @Resource
    UserService userService;
    @Override
    public List<CommentData> GetCommentsByAnimeID(String AnimeID){
        List<CommentData> commentDataList = commentMapper.GetCommentsByAnimeID(AnimeID);
        Collections.reverse(commentDataList);
        return commentDataList;
    }
    @Override
    public void AddCommentByAnimeID(CommentData commentData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        commentData.setCommentID(GetLatestID());
//        通过用户账号获取用户ID(前端返回的用户名实际是就是用户账号)
        commentData.setUserID(userService.GetUserIDByUserAccount(commentData.getUserName()));
        commentData.setCommentDate(simpleDateFormat.format(date));
        commentMapper.AddCommentByAnimeID(commentData);
    }
    @Override
    public int GetLatestID() {
        return commentMapper.GetAllComments().size()+1;
    }
}
