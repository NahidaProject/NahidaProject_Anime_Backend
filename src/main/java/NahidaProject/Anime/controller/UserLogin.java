package NahidaProject.Anime.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import NahidaProject.Anime.mapper.MainMapper;
import NahidaProject.Anime.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import NahidaProject.Anime.entity.UserData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api")
public class UserLogin {
    @Resource
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST,params = {"username","password"})
    @CrossOrigin
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserData userData = new UserData();
        userData.setUsername(request.getParameter("username"));
        userData.setPassword(request.getParameter("password"));
        boolean flag = userService.Login(userData);
        if(flag){
            response.getWriter().print("Success");
            response.setStatus(200);
        }else {
            response.getWriter().print("userDuplicated");
            response.setStatus(400);
        }
    }
}
