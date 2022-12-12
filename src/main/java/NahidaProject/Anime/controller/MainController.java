package NahidaProject.Anime.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@ResponseBody
public class MainController {
    @Value("${Nahida.project-name}")
    String PROJECT;

    @RequestMapping("/")
    //  访问localhost:1314返回Welcome To Nahida Anime Index Page
    public String index() {
        return "Welcome To Nahida " + PROJECT + " Index Page";
    }
    //  用于管理平台监测服务器状态
    @RequestMapping( "/serverStatus")
    public void serverStatus(HttpServletResponse response){
        response.setStatus(201);
    }
}
