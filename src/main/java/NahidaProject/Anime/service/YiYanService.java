package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.YiYanData;
import NahidaProject.Anime.mapper.YiYanMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class YiYanService {
    @Resource
    YiYanMapper yiYanMapper;
    @Resource
    AdminService adminService;
    public YiYanData RandomYiYan(){
        return yiYanMapper.Random();
    }
    public List<YiYanData> GetAllYiYan(){
        List<YiYanData> yiYanDataList;
        yiYanDataList = yiYanMapper.GetAllYiYan();
        return yiYanDataList;
    }
    public void NewYiYan(YiYanData yiYanData) {
        yiYanData.setAdminID(adminService.GetAdminIDByAccount(yiYanData.getAdminAccount()));
        yiYanMapper.NewYiYan(yiYanData);
    }
}
