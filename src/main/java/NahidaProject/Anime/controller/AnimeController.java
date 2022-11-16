package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.AnimeData;
import NahidaProject.Anime.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AnimeController {
    @Resource
    AnimeService animeService;

    @RequestMapping("/getAllAnime")
    @CrossOrigin
    @ResponseBody
    public List<AnimeData> getUserList() {
        List<AnimeData> animeDataList;
        animeDataList = animeService.findAllAnime();
        return animeDataList;
    }

    @RequestMapping(value = "/getAnimeById",method = RequestMethod.POST,params = {"a_id"})
    @CrossOrigin
    @ResponseBody
    public AnimeData getAnimeById(HttpServletRequest request,HttpServletResponse response){
        response.setStatus(200);
        return animeService.findAnimeById(request.getParameter("a_id"));
    }

    @RequestMapping(value = "/deleteAnime",method = RequestMethod.POST,params = {"a_id"})
    private void deleteAnime(HttpServletRequest request,HttpServletResponse response) throws IOException {
        boolean flag = animeService.deleteAnime(request.getParameter("a_id"));
        if (flag) {
            response.getWriter().print("Success");
            response.setStatus(200);
        } else {
            response.getWriter().print("forgot-something");
            response.setStatus(400);
        }
    }

    @RequestMapping(value = "/updateAnime", method = RequestMethod.POST, params = {
            "a_id", "a_name", "a_release_date", "a_company",
            "a_set", "a_type", "a_desc", "a_hot", "a_cv",
            "a_stats", "a_lang", "a_recommend"
    })
    @CrossOrigin
    @ResponseBody
    private void updateAnime(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AnimeData animeData = SetAnimeData(request);
        boolean flag = animeService.updateAnime(animeData);
        if (flag) {
            response.getWriter().print("Success");
            response.setStatus(200);
        } else {
            response.getWriter().print("forgot-something");
            response.setStatus(400);
        }
    }

    @RequestMapping(value = "/addAnime", method = RequestMethod.POST, params = {
            "a_id", "a_name", "a_release_date", "a_company",
            "a_set", "a_type", "a_desc", "a_hot", "a_cv",
            "a_stats", "a_lang", "a_recommend"
    })
    @CrossOrigin
    @ResponseBody
    private void addAnime(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AnimeData animeData = SetAnimeData(request);
        boolean flag = animeService.addAnime(animeData);
        if (flag) {
            response.getWriter().print("Success");
            response.setStatus(200);
        } else {
            response.getWriter().print("forgot-something");
            response.setStatus(400);
        }
    }

    private AnimeData SetAnimeData(HttpServletRequest request) {
        AnimeData animeData = new AnimeData();
        animeData.setA_id(request.getParameter("a_id"));
        animeData.setA_name(request.getParameter("a_name"));
        animeData.setA_release_date(request.getParameter("a_release_date"));
        animeData.setA_company(request.getParameter("a_company"));
        animeData.setA_set(Integer.parseInt(request.getParameter("a_set")));
        animeData.setA_type(request.getParameter("a_type"));
        animeData.setA_desc(request.getParameter("a_desc"));
        animeData.setA_hot(Integer.parseInt(request.getParameter("a_hot")));
        animeData.setA_cv(request.getParameter("a_cv"));
        animeData.setA_stats(request.getParameter("a_stats"));
        animeData.setA_lang(request.getParameter("a_lang"));
        animeData.setA_recommend(Boolean.valueOf(request.getParameter("a_recommend")));
        return animeData;
    }

}
