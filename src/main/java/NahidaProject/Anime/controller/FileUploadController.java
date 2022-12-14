package NahidaProject.Anime.controller;

import NahidaProject.Anime.service.FileUploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@ResponseBody
public class FileUploadController {

    //  动漫海报    根据动漫ID上传到指定目录
    @RequestMapping(value = "/AnimePosterUpload/{aid}", method = RequestMethod.POST)
    private Object AnimePosterUpload(@RequestParam("poster") MultipartFile poster, @PathVariable int aid) {
        return new FileUploadService().saveThisPoster(poster, aid);
    }
    //  动漫剧集    根据动漫ID上传到指定目录
    //  动漫视频文件命名    六位视频序号_三位视频集数.mp4
    //  前端传动漫ID
    @RequestMapping(value = "/AnimeVideosUpload/{aid}", method = RequestMethod.POST)
    private Object AnimeVideosUpload(@RequestParam("videos") MultipartFile videos, @PathVariable int aid) {
        return new FileUploadService().saveThisVideo(videos, aid);
    }

    @RequestMapping(value = "/NewsImageUpload/{NewsID}",method = RequestMethod.POST)
    private String NewsImageUpload(@RequestParam("image") MultipartFile image, @PathVariable int NewsID){
        return new FileUploadService().SaveNewsImage(image,NewsID);
    }
}
