package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.NewsData;
import NahidaProject.Anime.service.NewsService;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@ResponseBody
public class NewsController {
    @Resource
    NewsService newsService;
    Gson gson = new Gson();
//    获取所有资讯
    @RequestMapping("/GetAllNews")
    private List<NewsData> GetAllNews(){
        List<NewsData> newsDataList = newsService.GetAllNews();
        Collections.reverse(newsDataList);
        return newsDataList;
    }
//    获取当月热点
    @RequestMapping("/GetHotsList")
    private List<NewsData> GetHotsList(){
        return newsService.GetHotsList();
    }
//    通过资讯ID获取资讯内容
    @RequestMapping(value = "/GetNewsContentByID/{NewsID}",produces = "application/json;charset=UTF-8")
    private String GetNewsContentByID(@PathVariable int NewsID){
        return gson.toJson(newsService.GetNewsContentByID(NewsID));
    }
//    获取资讯ID
    @RequestMapping("/GetCurrentNewsID")
    private int GetNewsID(){
        return GetAllNews().size()+1;
    }
//    新增资讯
    @RequestMapping(value = "/NewNews",method = RequestMethod.POST)
    private String NewNews(@RequestBody NewsData newsData){
        return newsService.NewNews(newsData)?gson.toJson("SUCCESS"):gson.toJson("FAILED");
    }
//    更新资讯
    @RequestMapping(value = "UpdateNews",method = RequestMethod.PUT)
    private String UpdateNews(@RequestBody NewsData newsData){
        return newsService.UpdateNews(newsData)?gson.toJson("SUCCESS"):gson.toJson("FAILED");
    }
//    删除资讯
    @RequestMapping(value = "DeleteNews",method = RequestMethod.DELETE)
    private void DeleteNews(@RequestBody NewsData newsData){
        newsService.DeleteNews(newsData.getNewsID());
    }
//    资讯模糊查找
    @RequestMapping(value = "FindNews",method = RequestMethod.POST)
    private List<NewsData> FindNewsLike(@RequestBody NewsData newsData){
        return newsService.FindNewsLike(newsData.getNewsTitle());
    }
}
