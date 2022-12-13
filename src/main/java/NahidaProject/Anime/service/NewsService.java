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
}
