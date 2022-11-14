package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class UserRegister {
    @Resource
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, params = {"username", "password", "role"})
    @CrossOrigin
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserData userData = new UserData();
        userData.setUsername(request.getParameter("username"));
        userData.setPassword(request.getParameter("password"));
        userData.setRole(request.getParameter("role"));
        boolean flag = userService.Register(userData);
        if(flag){
            response.getWriter().print("Success");
            response.setStatus(200);
        }else {
            response.getWriter().print("userDuplicated");
            response.setStatus(400);
        }
    }
}
