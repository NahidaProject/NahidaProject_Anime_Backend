package NahidaProject.Anime.controller;

import NahidaProject.Anime.service.FileUploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@ResponseBody
@CrossOrigin
public class FileUploadController {
    @RequestMapping(value = "/animePosterUpload",method = RequestMethod.POST)
    public Object animePosterUpload(@RequestParam("poster")MultipartFile poster){
        return new FileUploadService().saveThisPoster(poster);
    }

    @RequestMapping(value = "/animeVideosUpload",method = RequestMethod.POST)
    public Object animeVideosUpload(@RequestParam("videos")MultipartFile videos){
        return new FileUploadService().saveThisVideo(videos);
    }


}
