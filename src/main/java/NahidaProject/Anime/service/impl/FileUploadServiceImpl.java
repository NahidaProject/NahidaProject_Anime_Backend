package NahidaProject.Anime.service.impl;

import NahidaProject.Anime.service.AnimeService;
import NahidaProject.Anime.service.FileUploadService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Resource
    AnimeService animeService;
    @Value("${Nahida.anime-path}")
    private String animePath;
    @Override
    public Object saveThisPoster(MultipartFile poster, int aid) {
        String posterName;
        if(aid>=10){
            posterName = animePath+"anime" + "/main_image/" + "0000"+aid + ".png";
        }else {
            posterName = animePath+"anime" + "/main_image/" + "00000" + aid + ".png";
        }
        File pFile = new File(posterName);
        try {
            poster.transferTo(pFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "nia~";
    }
    @Override
    public Object saveThisVideo(MultipartFile videos, int aid) {
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
            videoName = animePath+"anime" + "/videos/" + "0000"+aid + "/" + "0000"+aid + "_" + Episode + ".mp4";
        }else {
            videoName = animePath+"anime" + "/videos/" + "00000" + aid + "/" + "00000" + aid + "_" + Episode + ".mp4";
        }
        File pFile = new File(videoName);
        try {
            File dir = new File(animePath+"anime" + "/videos/" + "0000"+aid);
            if (dir.mkdirs()) {
                videos.transferTo(pFile);
            }else{
                videos.transferTo(pFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "nia~";
    }
    @Override
    public String SaveNewsImage(MultipartFile image,int NewsID){
        File pFile = new File(animePath+"anime"+"/news/card/"+NewsID+".jpg");
        try {
            image.transferTo(pFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "nia~";
    }
}
