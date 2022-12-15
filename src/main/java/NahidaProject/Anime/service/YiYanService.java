package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.YiYanData;

import java.util.List;

public interface YiYanService {
    YiYanData RandomYiYan();
    List<YiYanData> GetAllYiYan();
    void NewYiYan(YiYanData yiYanData);
}
