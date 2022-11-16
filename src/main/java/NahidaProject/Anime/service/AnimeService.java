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

    public AnimeData findAnimeById(String a_id){return animeMapper.findAnimeById(a_id);}

    public List<AnimeData> findAllAnime() {
        return animeMapper.findAllAnime();
    }

    public boolean addAnime(AnimeData animeData) {
        int x = animeMapper.addAnime(animeData);
        return x > 0;
    }

    public boolean updateAnime(AnimeData animeData){
        int x = animeMapper.updateAnime(animeData);
        return x>0;
    }

    public boolean deleteAnime(String a_id) {
        int x = animeMapper.deleteAnime(a_id);
        return x>0;
    }
}
