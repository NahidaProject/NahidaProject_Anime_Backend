package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.AnimeData;

import java.util.List;

public interface AnimeService {
    List<AnimeData> GetAllAnimes();
    AnimeData GetAnimeByID(int aid);
    boolean NewAnime(AnimeData animeData);
    boolean UpdateAnime(AnimeData animeData);
    void UpdateCV(String CVName,int AnimeID);
    void UpdateType(String AnimeType, int AnimeID);
    void DeleteAnime(int aid);
    void DeleteAllCVs(int aid);
    void DeleteAllTypes(int aid);
    //  将动漫ID关联动漫类型和动漫配音
    void AnimeMN(AnimeData animeData);

    List<AnimeData> GetRecommendAnimes();

    List<AnimeData> FilterAnimes(AnimeData animeData);
    List<AnimeData> GetAnimesByAnimeName(String AnimeName);
}
