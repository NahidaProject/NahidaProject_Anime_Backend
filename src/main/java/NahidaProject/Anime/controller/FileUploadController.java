package NahidaProject.Anime.controller;

import NahidaProject.Anime.service.AnimeService;
import NahidaProject.Anime.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/file")
@ResponseBody
@CrossOrigin
public class FileUploadController {

    @Resource
    AnimeService animeService;

    @Value("${Nahida.media-path}")
    String mediaPath;

    @RequestMapping(value = "/AnimePosterUpload/{aid}", method = RequestMethod.POST)
    public Object AnimePosterUpload(@RequestParam("poster") MultipartFile poster, @PathVariable int aid) {
        String posterName;
        if(aid>=10){
            posterName = mediaPath + "/main_image/" + "0000"+aid + ".png";
        }else {
            posterName = mediaPath + "/main_image/" + "00000" + aid + ".png";
        }
        return new FileUploadService().saveThisPoster(poster, posterName);
    }

    @RequestMapping(value = "/AnimeVideosUpload/{aid}", method = RequestMethod.POST)
    public Object AnimeVideosUpload(@RequestParam("videos") MultipartFile videos, @PathVariable int aid) {
        int EpisodeTmp = animeService.GetAnimeByID(aid).getAnimeEpisode();
        String Episode;
        if (EpisodeTmp >= 10 && EpisodeTmp <= 99) {
            Episode = "0" + EpisodeTmp;
        } else if (EpisodeTmp < 10) {
            Episode = "00" + EpisodeTmp;
        } else {
            Episode = "" + EpisodeTmp;
        }
        String videoName;
        if(aid>=10){
            videoName = mediaPath + "/videos/" + "0000"+aid + "/" + "0000"+aid + "_" + Episode + ".mp4";
        }else {
            videoName = mediaPath + "/videos/" + "00000" + aid + "/" + "00000" + aid + "_" + Episode + ".mp4";
        }
        return new FileUploadService().saveThisVideo(videos, videoName);
    }
}
