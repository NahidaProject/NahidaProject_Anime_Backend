package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.CommentData;

import java.util.List;

public interface CommentService {
    List<CommentData> GetCommentsByAnimeID(String AnimeID);
    void AddCommentByAnimeID(CommentData commentData);
    int GetLatestID();
}
