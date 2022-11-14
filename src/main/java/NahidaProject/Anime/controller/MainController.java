package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.mapper.MainMapper;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class MainController {

    @Resource
    MainMapper mapper;

    @Value("${Nahida.project}")
    String PROJECT;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome To Nahida " + PROJECT + " Index";
    }

    @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET)
    @CrossOrigin
    public void getAllUsers(HttpServletResponse response) throws IOException {
        List<UserData> u = mapper.findAllUsers();
        response.getWriter().print(u);
        response.flushBuffer();
        response.setStatus(200);
    }
}
