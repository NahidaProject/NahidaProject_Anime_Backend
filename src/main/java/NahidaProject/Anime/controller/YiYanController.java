package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.YiYanData;
import NahidaProject.Anime.service.YiYanService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/YiYan")
public class YiYanController {
    @Resource
    YiYanService yiYanService;
    //  随机一言 用于前端主站励志用户
    @RequestMapping("/Random")
    private YiYanData Random(){
        return yiYanService.RandomYiYan();
    }
    //  获取所有一言
    @RequestMapping("/GetAllYiYan")
    private List<YiYanData> GetAllYiYan(){
        return yiYanService.GetAllYiYan();
    }
    //  新增一言
    @RequestMapping(value = "/NewYiYan", method = RequestMethod.POST)
    private void AddYiYan(@RequestBody YiYanData yiYanData){yiYanService.NewYiYan(yiYanData);}
}
