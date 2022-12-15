package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.AnimeCVData;

import java.util.List;

public interface AnimeCVService {
    List<AnimeCVData> GetAllAnimeCV();
    void AddCV(AnimeCVData animeCVData);
    void DeleteCV(AnimeCVData animeCVData);
}
