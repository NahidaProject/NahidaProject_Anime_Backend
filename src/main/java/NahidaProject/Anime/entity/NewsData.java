package NahidaProject.Anime.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class NewsData {
    int NewsID;
    String NewsTitle;
    String NewsCategory;
    String NewsAuthor;
    Date NewsDate;
    int NewsViewCount;
    String NewsContent;
}
