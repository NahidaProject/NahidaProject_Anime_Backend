package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.NewsData;
import NahidaProject.Anime.mapper.NewsMapper;
import NahidaProject.Anime.utils.NewsFilter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Resource
    NewsMapper newsMapper;
    public List<NewsData> GetAllNews(){
        return newsMapper.GetAllNews();
    }
    public List<NewsData> GetHotsList(){
        return new NewsFilter().FilterHotsList(newsMapper.GetAllNews());
    }
    public String GetNewsContentByID(int NewsID){
        return newsMapper.GetNewsContentByID(NewsID);
    }
    public boolean NewNews(NewsData newsData) {
        int x = newsMapper.NewNews(newsData);
        return x > 0;
    }
    public boolean UpdateNews(NewsData newsData) {
        int x = newsMapper.UpdateNews(newsData);
        return x > 0;
    }
    public void DeleteNews(int newsID){
        newsMapper.DeleteNews(newsID);
    }
    public List<NewsData> FindNewsLike(String NewsLike){
        return newsMapper.FindNewsLike(NewsLike);
    }
}
