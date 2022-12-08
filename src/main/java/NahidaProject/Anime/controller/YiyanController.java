package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.YiyanData;
import NahidaProject.Anime.service.YiyanService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/api/yiyan")
public class YiyanController {
    @Resource
    YiyanService yiyanService;

    @RequestMapping(value = "/yiyanrandom",method = RequestMethod.GET)
    public YiyanData yiyanrandom(HttpServletResponse response){
        response.setStatus(200);
        return yiyanService.getRandomYiyan();
    }

    @RequestMapping(value = "/getallyiyan",method = RequestMethod.GET)
    public List<YiyanData> allyiyan(HttpServletResponse response){
        List<YiyanData> yiyanDataList;
        yiyanDataList = yiyanService.getAllYiyan();
        response.setStatus(200);
        return yiyanDataList;
    }

    @RequestMapping(value = "/addyiyan", method = RequestMethod.POST)
    private void addyiyan(@RequestBody YiyanData yiyanData, HttpServletResponse response) throws IOException {
        boolean flag = yiyanService.addYiyan(yiyanData);
        if (flag) {
            response.getWriter().print("Success");
            response.setStatus(200);
        } else {
            response.getWriter().print("forgot-something");
            response.setStatus(400);
        }
    }
}
