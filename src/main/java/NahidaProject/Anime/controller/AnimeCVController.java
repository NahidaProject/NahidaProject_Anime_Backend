package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.AnimeCVData;
import NahidaProject.Anime.service.AnimeCVService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animecv")
@ResponseBody
public class AnimeCVController {
    @Resource
    AnimeCVService animeCVService;
    @RequestMapping("/GetAllCV")
    private List<AnimeCVData> GetAllCV(){
        return animeCVService.GetAllAnimeCV();
    }
    @RequestMapping(value = "/AddCV",method = RequestMethod.POST)
    private void AddCV(@RequestBody AnimeCVData animeCVData){
        animeCVService.AddCV(animeCVData);
    }
    @RequestMapping(value = "/DeleteCV",method = RequestMethod.POST)
    private void DeleteCV(@RequestBody AnimeCVData animeCVData){
        animeCVService.DeleteCV(animeCVData);
    }
    @RequestMapping("GetCVByAnimeID/{AnimeID}")
    private List<AnimeCVData> GetCVByAnimeID(@PathVariable int AnimeID){
        return animeCVService.GetCVByAnimeID(AnimeID);
    }
}
