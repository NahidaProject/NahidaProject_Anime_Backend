package NahidaProject.Anime.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Value("${Nahida.project}")
    String PROJECT;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome To Nahida " + PROJECT + " Index";
    }
}
