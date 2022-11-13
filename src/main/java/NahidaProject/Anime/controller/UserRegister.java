package NahidaProject.Anime.controller;

import NahidaProject.Anime.mapper.MainMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api")
public class UserRegister {

    @Resource
    MainMapper mapper;

    @RequestMapping(value = "/register",method = RequestMethod.POST,params = {"username","password","role"})
    public void register(HttpServletRequest request, HttpServletResponse response){
        mapper.addUser(
                request.getParameter("username"),
                request.getParameter("password"),
                request.getParameter("role"));
        response.setStatus(200);
    }
}
