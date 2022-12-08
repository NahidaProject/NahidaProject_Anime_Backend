package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.AnimeData;
import NahidaProject.Anime.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/anime")
@ResponseBody
@CrossOrigin
public class AnimeController {
    @Resource
    AnimeService animeService;

    @RequestMapping(value = "/getAllAnime",method = RequestMethod.GET)
    public List<AnimeData> getUserList() {
        List<AnimeData> animeDataList;
        animeDataList = animeService.findAllAnime();
        return animeDataList;
    }

    @RequestMapping(value = "/getAnimeById/{a_id}",method = RequestMethod.GET)
    public AnimeData getAnimeById(HttpServletResponse response, @PathVariable String a_id){
        response.setStatus(200);
        return animeService.findAnimeById(a_id);
    }

    @RequestMapping(value = "/deleteAnime",method = RequestMethod.DELETE)
    private void deleteAnime(@RequestBody AnimeData animeData,HttpServletResponse response) throws IOException {
        boolean flag = animeService.deleteAnime(animeData.getA_id());
        if (flag) {
            response.getWriter().print("Success");
            response.setStatus(200);
        } else {
            response.getWriter().print("forgot-something");
            response.setStatus(400);
        }
    }

    @RequestMapping(value = "/updateAnime", method = RequestMethod.PUT)
    private void updateAnime(@RequestBody AnimeData animeData, HttpServletResponse response) throws IOException {
        boolean flag = animeService.updateAnime(animeData);
        if (flag) {
            response.getWriter().print("Success");
            response.setStatus(200);
        } else {
            response.getWriter().print("forgot-something");
            response.setStatus(400);
        }
    }

    @RequestMapping(value = "/addAnime", method = RequestMethod.POST)
    private void addAnime(@RequestBody AnimeData animeData, HttpServletResponse response) throws IOException {
        boolean flag = animeService.addAnime(animeData);
        if (flag) {
            response.getWriter().print("Success");
            response.setStatus(200);
        } else {
            response.getWriter().print("forgot-something");
            response.setStatus(400);
        }
    }
}
