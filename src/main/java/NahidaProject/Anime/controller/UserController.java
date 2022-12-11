package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.service.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/GetAllUsers")
    public List<UserData> GetAllUsers(){
        List<UserData> userDataList;
        userDataList = userService.GetAllUsers();
        return userDataList;
    }

    @RequestMapping(value = "NewUser",method = RequestMethod.POST)
    public String NewUser(@RequestBody UserData userData){
        Gson gson = new Gson();
        if(userService.NewUser(userData)){
            return gson.toJson("SUCCESS");
        }else {
            return gson.toJson("FAILED");
        }
    }

    @RequestMapping(value = "DeleteUser",method = RequestMethod.DELETE)
    public String DeleteUser(@RequestBody UserData userData){
        Gson gson = new Gson();
        userService.DeleteUser(userData.getUserID());
        return gson.toJson("SUCCESS");
    }

    @RequestMapping(value = "UpdateUser",method = RequestMethod.PUT)
    public String UpdateUser(@RequestBody UserData userData){
        Gson gson = new Gson();
        if(userService.UpdateUser(userData)){
            return gson.toJson("SUCCESS");
        }else {
            return gson.toJson("FAILED");
        }
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestBody UserData userData, HttpSession session,HttpServletResponse response){
        Gson gson = new Gson();
        if(userService.GetUserPassword(userData)==null){
//            用户不存在或密码错误
            session.setAttribute("isLogin",false);
            response.setStatus(403);
            Cookie cookie = new Cookie("Account","NULL");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return gson.toJson("USER NOT FOUND OR INCORRECT PASSWORD");
        }else{
//            登录成功
            session.setAttribute("isLogin",true);
            Cookie cookie = new Cookie("Account",userData.getUserAccount());
//            cookies保存3600s, 也就是1小时后需要重新登录
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            response.addCookie(cookie);
            return gson.toJson("SUCCESS");
        }
    }
}
