package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.NewsData;

import java.util.List;

public interface NewsService {
    List<NewsData> GetAllNews();
    List<NewsData> GetHotsList();
    String GetNewsContentByID(int NewsID);
    boolean NewNews(NewsData newsData);
    boolean UpdateNews(NewsData newsData);
    void DeleteNews(int newsID);
    List<NewsData> FindNewsLike(String NewsLike);
}
