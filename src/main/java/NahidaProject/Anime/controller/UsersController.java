package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@Controller
@RequestMapping("/api")
public class UsersController {
    @Resource
    UserService userService;

    @RequestMapping("/getAllUsers")
    @CrossOrigin
    @ResponseBody
    public List<UserData> getUserList(){
        List<UserData> userDataList;
        userDataList = userService.findAllUsers();
        return userDataList;
    }

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

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST,params = {"id","username","password","role","currentUser"})
    @CrossOrigin
    private void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
        UserData u = userService.findUserByName(request.getParameter("currentUser"));
        if(!Objects.equals(u.getRole(), "Admin")){
            response.getWriter().print("Fail");
            response.setStatus(400);
        }else {
            UserData userData = new UserData();
            userData.setId(Integer.parseInt(request.getParameter("id")));
            userData.setUsername(request.getParameter("username"));
            userData.setPassword(request.getParameter("password"));
            userData.setRole(request.getParameter("role"));
            boolean flag = userService.Update(userData);
            if(flag){
                response.getWriter().print("Success");
                response.setStatus(200);
            }else {
                response.getWriter().print("Fail");
                response.setStatus(400);
            }
        }
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST,params = {"username","currentUser"})
    @CrossOrigin
    private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserData u = userService.findUserByName(request.getParameter("currentUser"));
        if(!Objects.equals(u.getRole(), "Admin")){
            response.getWriter().print("Fail");
            response.setStatus(400);
        }else {
            UserData userData = new UserData();
            userData.setUsername(request.getParameter("username"));
            boolean flag = userService.Delete(userData);
            if (flag) {
                response.getWriter().print("Success");
                response.setStatus(200);
            } else {
                response.getWriter().print("Fail");
                response.setStatus(400);
            }
        }
    }
}
