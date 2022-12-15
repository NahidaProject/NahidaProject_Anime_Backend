package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.AnimeData;
import NahidaProject.Anime.service.AnimeService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/anime")
@ResponseBody
public class AnimeController {
    @Resource
    AnimeService animeService;
    //  新增动漫
    Gson gson = new Gson();
    @RequestMapping(value = "/NewAnime",method = RequestMethod.POST)
    private String NewAnime(@RequestBody AnimeData animeData){
        return animeService.NewAnime(animeData)?gson.toJson("SUCCESS"):gson.toJson("FAILED");
    }
    //  获取所有动漫
    @RequestMapping("/GetAllAnimes")
    private List<AnimeData> GetAllAnimes(){
        return animeService.GetAllAnimes();
    }
    //  通过ID获取动漫
    @RequestMapping(value = "/GetAnimeByID/{aid}")
    private AnimeData GetAnimeByID(@PathVariable int aid){
        return animeService.GetAnimeByID(aid);
    }
    //  更新动漫
    @RequestMapping(
            value = "/UpdateAnime",
            method = {RequestMethod.PUT,RequestMethod.POST},
            produces = "application/json;charset=UTF-8")
    private String UpdateAnime(@RequestBody AnimeData animeData){
    //  先删除目标动漫类型和CV
        animeService.DeleteAllTypes(animeData.getAnimeID());
        animeService.DeleteAllCVs(animeData.getAnimeID());
        return animeService.UpdateAnime(animeData)?gson.toJson("SUCCESS"):gson.toJson("失败");
    }
    //  删除动漫
    @RequestMapping(value = "/DeleteAnime",method = RequestMethod.DELETE)
    private void DeleteAnime(@RequestBody AnimeData animeData){
        animeService.DeleteAnime(animeData.getAnimeID());
    }
    //  获取推荐动漫
    @RequestMapping(value = "/GetRecommendAnimes")
    private List<AnimeData> GetRecommendAnimes(){return animeService.GetRecommendAnimes();}
    //  根据地区/状态/风格筛选动漫
    @RequestMapping(value = "/FilterAnimes",method = RequestMethod.POST)
    private List<AnimeData> FilterAnimes(@RequestBody AnimeData animeData){
        return animeService.FilterAnimes(animeData);
    }
    //  模糊查询
    @RequestMapping("/GetAnimeByFuzzyQuery/{FuzzyName}")
    private List<AnimeData> GetAnimeByFuzzyQuery(@PathVariable String FuzzyName){
        return animeService.GetAnimesByAnimeName(FuzzyName);
    }
}
