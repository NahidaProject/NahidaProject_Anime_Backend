package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.AnimeData;
import NahidaProject.Anime.mapper.AnimeMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AnimeService {
    @Resource
    AnimeMapper animeMapper;
    public List<AnimeData> GetAllAnimes(){
        return animeMapper.GetAllAnimes();
    };
    public AnimeData GetAnimeByID(int aid){
        return animeMapper.GetAnimeByID(aid);
    }
    public boolean NewAnime(AnimeData animeData){
        int x = animeMapper.NewAnime(animeData);
        AnimeMN(animeData);
        return x > 0;
    }
    public boolean UpdateAnime(AnimeData animeData){
        int x = animeMapper.UpdateAnime(animeData);
        AnimeMN(animeData);
        return x > 0;
    }
    public void UpdateCV(String CVName,int AnimeID){
        animeMapper.UpdateCV(CVName,AnimeID);
    }
    public void UpdateType(String AnimeType, int AnimeID) {animeMapper.UpdateType(AnimeType,AnimeID);}
    public void DeleteAnime(int aid){
        animeMapper.DeleteAnime(aid);
    }
    public void DeleteAllCVs(int aid) {
        animeMapper.DeleteAllCVs(aid);
    }
    public void DeleteAllTypes(int aid) {animeMapper.DeleteAllTypes(aid);}
    //  将动漫ID关联动漫类型和动漫配音
    private void AnimeMN(AnimeData animeData) {
        String[] AnimeType = animeData.getAnimeType().split(",");
        for (String type:AnimeType) {
            UpdateType(type,animeData.getAnimeID());
        }
        String[] CVName = animeData.getCVName().split(",");
        for (String name:CVName) {
            UpdateCV(name,animeData.getAnimeID());
        }
    }

    public List<AnimeData> GetRecommendAnimes() {
        return animeMapper.GetRecommendAnimes();
    }

    public List<AnimeData> FilterAnimes(AnimeData animeData) {
        List<AnimeData> AllAnimes = GetAllAnimes();
        if(Objects.equals(animeData.getAnimeLanguage(), "")){
            animeData.setAnimeLanguage(null);
        }
        if(Objects.equals(animeData.getAnimeType(), "")){
            animeData.setAnimeType(null);
        }
        if(Objects.equals(animeData.getAnimeStats(), "")){
            animeData.setAnimeStats(null);
        }
        return AllAnimes.stream().filter(s->
                (animeData.getAnimeStats()==null||s.getAnimeStats().equals(animeData.getAnimeStats()))&&
                (animeData.getAnimeLanguage()==null||s.getAnimeLanguage().equals(animeData.getAnimeLanguage()))&&
                (animeData.getAnimeType()==null||s.getAnimeType().contains(animeData.getAnimeType())))
                .toList();
    }
    public List<AnimeData> GetAnimesByAnimeName(String AnimeName){
        String ConcatName = "%"+AnimeName+"%";
        return animeMapper.GetAnimesByAnimeName(ConcatName);
    }
}
