package NahidaProject.Anime.entity;

import lombok.Data;

@Data
public class CommentData {
    int CommentID;
    String CommentDate;
    String CommentText;
    int UserID;
    int AnimeID;
    String UserName;
}
