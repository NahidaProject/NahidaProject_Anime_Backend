package NahidaProject.Anime.utils;

import NahidaProject.Anime.entity.NewsData;

import java.util.List;

public class NewsFilter {
    public List<NewsData> FilterHotsList(List<NewsData> newsDataList){
//        根据阅读量降序排序
//        Lambda
        newsDataList.sort((o1, o2) -> o2.getNewsViewCount()-o1.getNewsViewCount());
        if(newsDataList.size()>=5){
//            返回5个阅读量最多的
            return newsDataList.subList(0,5);
        }else {
            return newsDataList;
        }
    }
}
