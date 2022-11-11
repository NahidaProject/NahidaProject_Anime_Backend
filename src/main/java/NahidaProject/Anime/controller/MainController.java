package NahidaProject.Anime.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Value("${Nahida.project}")
    String PROJECT;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome To Nahida " + PROJECT + " Index";
    }
}
