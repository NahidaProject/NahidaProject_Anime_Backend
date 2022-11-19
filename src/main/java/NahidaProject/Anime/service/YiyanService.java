package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.YiyanData;
import NahidaProject.Anime.mapper.YiyanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YiyanService {
    @Resource
    YiyanMapper yiyanMapper;

    public YiyanData getRandomYiyan(){
        return yiyanMapper.random();
    }

    public List<YiyanData> getAllYiyan(){
        return yiyanMapper.getAllYiyan();
    }

    public boolean addYiyan(YiyanData yiyanData) {
        int x = yiyanMapper.addYiyan(yiyanData);
        return x > 0;
    }
}
