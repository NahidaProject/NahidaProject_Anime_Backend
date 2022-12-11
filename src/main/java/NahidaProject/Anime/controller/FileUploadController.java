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

    //  将配置文件的Nahida.media-path赋值给mediaPath
    @Value("${Nahida.media-path}")
    String mediaPath;
    //  动漫海报    根据动漫ID上传到指定目录
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
    //  动漫剧集    根据动漫ID上传到指定目录
    //  动漫视频文件命名    六位视频序号_三位视频集数.mp4
    //  前端传动漫ID
    @RequestMapping(value = "/AnimeVideosUpload/{aid}", method = RequestMethod.POST)
    public Object AnimeVideosUpload(@RequestParam("videos") MultipartFile videos, @PathVariable int aid) {
        //  获取数据库钟动漫最新剧集
        int EpisodeTmp = animeService.GetAnimeByID(aid).getAnimeEpisode();
        String Episode;
        //  如果剧集数大于等于10小于等于90在新增剧集ID前加一个0
        //  小于10加两个0
        //  其它直接使用上传剧集(大于99)
        if (EpisodeTmp >= 10 && EpisodeTmp <= 99) {
            Episode = "0" + EpisodeTmp;
        } else if (EpisodeTmp < 10) {
            Episode = "00" + EpisodeTmp;
        } else {
            Episode = "" + EpisodeTmp;
        }
        String videoName;
        if(aid>=10){
            //  存放路径为 mediaPath/videos/六位视频序号/六位视频序号_三位视频集数.mp4
            videoName = mediaPath + "/videos/" + "0000"+aid + "/" + "0000"+aid + "_" + Episode + ".mp4";
        }else {
            videoName = mediaPath + "/videos/" + "00000" + aid + "/" + "00000" + aid + "_" + Episode + ".mp4";
        }
        return new FileUploadService().saveThisVideo(videos, videoName);
    }
}
