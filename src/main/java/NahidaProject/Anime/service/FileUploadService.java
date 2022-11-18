package NahidaProject.Anime.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public Object saveThisPoster(MultipartFile poster){
        String posterName = poster.getOriginalFilename();
        assert posterName != null;
        File pFile = new File("F:/anime/main_image/"+posterName);
        try {
            poster.transferTo(pFile);
        }catch (IOException e){
            e.printStackTrace();
            return "上传失败";
        }
        return "nia~";
    }

    public Object saveThisVideo(MultipartFile videos) {
        String posterName = videos.getOriginalFilename();
        assert posterName != null;
        File pFile = new File("F:/anime/videos/"+posterName.substring(0,6)+"/"+posterName);
        try {
            videos.transferTo(pFile);
        }catch (IOException e){
            e.printStackTrace();
            return "上传失败";
        }
        return "nia~";
    }
}
