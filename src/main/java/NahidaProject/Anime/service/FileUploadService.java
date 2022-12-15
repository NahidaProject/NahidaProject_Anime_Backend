package NahidaProject.Anime.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    Object saveThisPoster(MultipartFile poster, int aid);
    Object saveThisVideo(MultipartFile videos, int aid);
    String SaveNewsImage(MultipartFile image,int NewsID);
}
