package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.YiYanData;
import NahidaProject.Anime.mapper.YiYanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YiYanService {
    @Resource
    YiYanMapper yiYanMapper;

    public YiYanData RandomYiYan(){
        return yiYanMapper.Random();
    }

    public List<YiYanData> GetAllYiYan(){
        return yiYanMapper.GetAllYiYan();
    }

    public boolean NewYiYan(YiYanData yiYanData) {
        int x = yiYanMapper.NewYiYan(yiYanData);
        return x > 0;
    }
}
