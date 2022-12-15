package NahidaProject.Anime.service.impl;

import NahidaProject.Anime.entity.YiYanData;
import NahidaProject.Anime.mapper.YiYanMapper;
import NahidaProject.Anime.service.AdminService;
import NahidaProject.Anime.service.YiYanService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YiYanServiceImpl implements YiYanService {
    @Resource
    YiYanMapper yiYanMapper;
    @Resource
    AdminService adminService;
    @Override
    public YiYanData RandomYiYan(){
        return yiYanMapper.Random();
    }
    @Override
    public List<YiYanData> GetAllYiYan(){
        List<YiYanData> yiYanDataList;
        yiYanDataList = yiYanMapper.GetAllYiYan();
        return yiYanDataList;
    }
    @Override
    public void NewYiYan(YiYanData yiYanData) {
        yiYanData.setAdminID(adminService.GetAdminIDByAccount(yiYanData.getAdminAccount()));
        yiYanMapper.NewYiYan(yiYanData);
    }
}
