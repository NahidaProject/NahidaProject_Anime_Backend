package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.YiYanData;
import NahidaProject.Anime.service.AdminService;
import NahidaProject.Anime.service.YiYanService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/api/YiYan")
public class YiYanController {
    @Resource
    YiYanService yiYanService;
    @Resource
    AdminService adminService;

    @RequestMapping("/Random")
    public YiYanData Random(){
        return yiYanService.RandomYiYan();
    }

    @RequestMapping("/GetAllYiYan")
    public List<YiYanData> GetAllYiYan(){
        List<YiYanData> yiYanDataList;
        yiYanDataList = yiYanService.GetAllYiYan();
        return yiYanDataList;
    }

    @RequestMapping(value = "/NewYiYan", method = RequestMethod.POST)
    private void AddYiYan(@RequestBody YiYanData yiYanData){
        yiYanData.setAdminID(adminService.GetAdminIDByAccount(yiYanData.getAdminAccount()));
        yiYanService.NewYiYan(yiYanData);
    }
}
