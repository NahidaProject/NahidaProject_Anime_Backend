package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.AnimeCVData;
import NahidaProject.Anime.mapper.AnimeCVMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeCVService {
    @Resource
    AnimeCVMapper animeCVMapper;
    public List<AnimeCVData> GetAllAnimeCV(){
        return animeCVMapper.GetAllAnimeCV();
    }
    public void AddCV(AnimeCVData animeCVData){
        animeCVData.setCVID(GetAllAnimeCV().size()+1);
        animeCVMapper.AddCV(animeCVData);
    }

    public void DeleteCV(AnimeCVData animeCVData) {
        animeCVMapper.DeleteCV(animeCVData.getCVName());
    }
}
