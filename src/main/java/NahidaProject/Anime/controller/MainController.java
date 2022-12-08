package NahidaProject.Anime.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@ResponseBody
@CrossOrigin
public class MainController {
    @Value("${Nahida.project-name}")
    String PROJECT;

    @RequestMapping("/")
    public String index() {
        return "Welcome To Nahida " + PROJECT + " Index Page";
    }

    @RequestMapping(value = "/serverStatus",method = RequestMethod.GET)
    public void serverStatus(HttpServletResponse response){
        response.setStatus(201);
    }
}
