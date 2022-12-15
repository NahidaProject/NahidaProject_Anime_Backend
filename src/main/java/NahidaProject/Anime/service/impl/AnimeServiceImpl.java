package NahidaProject.Anime.service.impl;

import NahidaProject.Anime.entity.AnimeData;
import NahidaProject.Anime.mapper.AnimeMapper;
import NahidaProject.Anime.service.AnimeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnimeServiceImpl implements AnimeService {
    @Resource
    AnimeMapper animeMapper;
    @Override
    public List<AnimeData> GetAllAnimes(){
        return animeMapper.GetAllAnimes();
    }
    @Override
    public AnimeData GetAnimeByID(int aid){
        return animeMapper.GetAnimeByID(aid);
    }
    @Override
    public boolean NewAnime(AnimeData animeData){
        int x = animeMapper.NewAnime(animeData);
        AnimeMN(animeData);
        return x > 0;
    }
    @Override
    public boolean UpdateAnime(AnimeData animeData){
        int x = animeMapper.UpdateAnime(animeData);
        AnimeMN(animeData);
        return x > 0;
    }
    @Override
    public void UpdateCV(String CVName,int AnimeID){
        animeMapper.UpdateCV(CVName,AnimeID);
    }
    @Override
    public void UpdateType(String AnimeType, int AnimeID) {animeMapper.UpdateType(AnimeType,AnimeID);}
    @Override
    public void DeleteAnime(int aid){
        animeMapper.DeleteAnime(aid);
    }
    @Override
    public void DeleteAllCVs(int aid) {
        animeMapper.DeleteAllCVs(aid);
    }
    @Override
    public void DeleteAllTypes(int aid) {animeMapper.DeleteAllTypes(aid);}
    @Override
    //  将动漫ID关联动漫类型和动漫配音
    public void AnimeMN(AnimeData animeData) {
        String[] AnimeType = animeData.getAnimeType().split(",");
        for (String type:AnimeType) {
            UpdateType(type,animeData.getAnimeID());
        }
        String[] CVName = animeData.getCVName().split(",");
        for (String name:CVName) {
            UpdateCV(name,animeData.getAnimeID());
        }
    }
    @Override
    public List<AnimeData> GetRecommendAnimes() {
        return animeMapper.GetRecommendAnimes();
    }
    @Override
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
    @Override
    public List<AnimeData> GetAnimesByAnimeName(String AnimeName){
        String ConcatName = "%"+AnimeName+"%";
        return animeMapper.GetAnimesByAnimeName(ConcatName);
    }
}
