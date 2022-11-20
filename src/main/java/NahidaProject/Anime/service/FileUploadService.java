package NahidaProject.Anime.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public Object saveThisPoster(MultipartFile poster, String posterName) {
        File pFile = new File(posterName);
        try {
            poster.transferTo(pFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "nia~";
    }

    public Object saveThisVideo(MultipartFile videos, String videoName) {
        File pFile = new File(videoName);
        try {
            videos.transferTo(pFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "nia~";
    }
}
