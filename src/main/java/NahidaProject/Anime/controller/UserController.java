package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.service.UserService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;
    Gson gson = new Gson();
    //  获取所有用户
    @RequestMapping("/GetAllUsers")
    public List<UserData> GetAllUsers(){
        return userService.GetAllUsers();
    }
    //  获取最新用户ID并且加1 用于注册用户设置UserID
    @RequestMapping("/GetCurrentUserID")
    public int GetUserID(){
        return GetAllUsers().size()+1;
    }
    //  注册用户
    @RequestMapping(value = "NewUser",method = RequestMethod.POST)
    public String NewUser(@RequestBody UserData userData){
        return userService.NewUser(userData)?gson.toJson("SUCCESS"):gson.toJson("FAILED");
    }
    //  删除用户
    @RequestMapping(value = "DeleteUser",method = RequestMethod.DELETE)
    public String DeleteUser(@RequestBody UserData userData){
        userService.DeleteUser(userData.getUserID());
        return gson.toJson("SUCCESS");
    }
    //  更新用户资料
    @RequestMapping(value = "UpdateUser",method = RequestMethod.PUT)
    public String UpdateUser(@RequestBody UserData userData){
        return userService.UpdateUser(userData)?gson.toJson("SUCCESS"):gson.toJson("FAILED");
    }
    //  用户登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestBody UserData userData, HttpSession session,HttpServletResponse response){
        if(!userService.Certification(userData)){
    //  用户不存在或密码错误
            response.setStatus(403);
            return gson.toJson("USER NOT FOUND OR INCORRECT PASSWORD");
        }else{
    //  登录成功
            session.setAttribute("USER_SESSION",userData);
            Cookie cookie = new Cookie("Account",userService.GetUserName(userData));
    //  cookies保存3600s, 也就是1小时后需要重新登录
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            response.addCookie(cookie);
            return gson.toJson("SUCCESS");
        }
    }
    //  忘记密码
    @RequestMapping(value = "forgot",method = RequestMethod.POST)
    public String forgot(@RequestBody UserData userData){
        return userService.ResetPassword(userData)?gson.toJson("SUCCESS"):gson.toJson("FAILED");
    }
}
