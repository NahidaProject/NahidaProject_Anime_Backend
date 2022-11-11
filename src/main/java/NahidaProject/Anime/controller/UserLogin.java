package NahidaProject.Anime.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import NahidaProject.Anime.entity.UserData;

@Controller
public class UserLogin {
    @CrossOrigin
    @PostMapping("/LoginTest")
    @ResponseBody
    public Map<String, Object> LoginTest(@RequestBody UserData userData) {
        System.out.println("实体："+userData.toString());
        Map<String,Object> map = new HashMap<>();
        map.put("userData",userData);
        map.put("code",200);
        map.put("msg","请求成功~");
        return map;
    }
}
