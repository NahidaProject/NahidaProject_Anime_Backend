package NahidaProject.Anime.service.impl;

import NahidaProject.Anime.entity.NewsData;
import NahidaProject.Anime.mapper.NewsMapper;
import NahidaProject.Anime.service.NewsService;
import NahidaProject.Anime.utils.NewsFilter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    NewsMapper newsMapper;
    @Override
    public List<NewsData> GetAllNews(){
        return newsMapper.GetAllNews();
    }
    @Override
    public List<NewsData> GetHotsList(){
        return new NewsFilter().FilterHotsList(newsMapper.GetAllNews());
    }
    @Override
    public String GetNewsContentByID(int NewsID){
        return newsMapper.GetNewsContentByID(NewsID);
    }
    @Override
    public boolean NewNews(NewsData newsData) {
        int x = newsMapper.NewNews(newsData);
        return x > 0;
    }
    @Override
    public boolean UpdateNews(NewsData newsData) {
        int x = newsMapper.UpdateNews(newsData);
        return x > 0;
    }
    @Override
    public void DeleteNews(int newsID){
        newsMapper.DeleteNews(newsID);
    }
    @Override
    public List<NewsData> FindNewsLike(String NewsLike){
        return newsMapper.FindNewsLike(NewsLike);
    }
}
