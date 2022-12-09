package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.AnimeData;
import NahidaProject.Anime.mapper.AnimeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        return x > 0;
    }

    public boolean UpdateAnime(AnimeData animeData){
        int x = animeMapper.UpdateAnime(animeData);
        return x > 0;
    }

    public void UpdateCV(String CVName,int AnimeID){
        animeMapper.UpdateCV(CVName,AnimeID);
    }

    public void UpdateType(String AnimeType, int AnimeID) {
        animeMapper.UpdateType(AnimeType,AnimeID);
    }

    public void DeleteAnime(int aid){
        animeMapper.DeleteAnime(aid);
    }

    public void DeleteAllCVs(int aid) {
        animeMapper.DeleteAllCVs(aid);
    }

    public void DeleteAllTypes(int aid) {
        animeMapper.DeleteAllTypes(aid);
    }
}
