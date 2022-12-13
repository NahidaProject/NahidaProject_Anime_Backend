package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.NewsData;
import NahidaProject.Anime.service.NewsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@ResponseBody
public class NewsController {
    @Resource
    NewsService newsService;
    @RequestMapping("/GetAllNews")
    public List<NewsData> GetAllNews(){
        return newsService.GetAllNews();
    }
    @RequestMapping("/GetHotsList")
    public List<NewsData> GetHotsList(){
        return newsService.GetHotsList();
    }
}
