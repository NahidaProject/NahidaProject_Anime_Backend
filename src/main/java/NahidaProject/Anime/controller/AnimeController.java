package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.AnimeData;
import NahidaProject.Anime.service.AnimeService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/anime")
@ResponseBody
@CrossOrigin
public class AnimeController {
    @Resource
    AnimeService animeService;

    @RequestMapping(value = "/NewAnime",method = RequestMethod.POST)
    private String NewAnime(@RequestBody AnimeData animeData){
        Gson gson = new Gson();
        AnimeMN(animeData);
        if(animeService.NewAnime(animeData)){
           return gson.toJson("SUCCESS");
        }else {
           return gson.toJson("FAILED");
        }
    }

    @RequestMapping("/GetAllAnimes")
    private List<AnimeData> GetAllAnimes(){
        return animeService.GetAllAnimes();
    }

    @RequestMapping(value = "/GetAnimeByID/{aid}")
    private AnimeData GetAnimeByID(@PathVariable int aid){
        return animeService.GetAnimeByID(aid);
    }

    @RequestMapping(
            value = "/UpdateAnime",
            method = {RequestMethod.PUT,RequestMethod.POST},
            produces = "application/json;charset=UTF-8")
    private String UpdateAnime(@RequestBody AnimeData animeData){
        Gson gson = new Gson();
        animeService.DeleteAllTypes(animeData.getAnimeID());
        animeService.DeleteAllCVs(animeData.getAnimeID());
        AnimeMN(animeData);
        if(animeService.UpdateAnime(animeData)){
            return gson.toJson("SUCCESS");
        }else{
            return gson.toJson("失败");
        }
    }

    @RequestMapping(value = "/DeleteAnime",method = RequestMethod.DELETE)
    private void DeleteAnime(@RequestBody AnimeData animeData){
        animeService.DeleteAnime(animeData.getAnimeID());
    }

    private void AnimeMN(@RequestBody AnimeData animeData) {
        String[] AnimeType = animeData.getAnimeType().split(",");
        for (String type:AnimeType) {
            animeService.UpdateType(type,animeData.getAnimeID());
        }
        String[] CVName = animeData.getCVName().split(",");
        for (String name:CVName) {
            animeService.UpdateCV(name,animeData.getAnimeID());
        }
    }
}
