package NahidaProject.Anime.service.impl;

import NahidaProject.Anime.entity.AnimeCVData;
import NahidaProject.Anime.mapper.AnimeCVMapper;
import NahidaProject.Anime.service.AnimeCVService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnimeCVServiceImpl implements AnimeCVService {
    @Resource
    AnimeCVMapper animeCVMapper;
    @Override
    public List<AnimeCVData> GetAllAnimeCV(){
        return animeCVMapper.GetAllAnimeCV();
    }
    @Override
    public void AddCV(AnimeCVData animeCVData){
        animeCVData.setCVID(GetAllAnimeCV().size()+1);
        animeCVMapper.AddCV(animeCVData);
    }
    @Override
    public void DeleteCV(AnimeCVData animeCVData) {
        animeCVMapper.DeleteCV(animeCVData.getCVName());
    }
}
