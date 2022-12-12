package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.service.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
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
    //  获取所有用户
    @RequestMapping("/GetAllUsers")
    public List<UserData> GetAllUsers(){
        List<UserData> userDataList;
        userDataList = userService.GetAllUsers();
        return userDataList;
    }
    //  获取最新用户ID并且加1 用于注册用户设置UserID
    @RequestMapping("/GetCurrentUserID")
    public int GetUserID(){
        List<UserData> allUsers = GetAllUsers();
        return allUsers.size()+1;
    }
    //  注册用户
    @RequestMapping(value = "NewUser",method = RequestMethod.POST)
    public String NewUser(@RequestBody UserData userData){
        Gson gson = new Gson();
        if(userService.NewUser(userData)){
            return gson.toJson("SUCCESS");
        }else {
            return gson.toJson("FAILED");
        }
    }
    //  删除用户
    @RequestMapping(value = "DeleteUser",method = RequestMethod.DELETE)
    public String DeleteUser(@RequestBody UserData userData){
        Gson gson = new Gson();
        userService.DeleteUser(userData.getUserID());
        return gson.toJson("SUCCESS");
    }
    //  更新用户资料
    @RequestMapping(value = "UpdateUser",method = RequestMethod.PUT)
    public String UpdateUser(@RequestBody UserData userData){
        Gson gson = new Gson();
        if(userService.UpdateUser(userData)){
            return gson.toJson("SUCCESS");
        }else {
            return gson.toJson("FAILED");
        }
    }
    //  用户登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestBody UserData userData, HttpSession session,HttpServletResponse response){
        Gson gson = new Gson();
        if(userService.GetUserPassword(userData)==null){
    //  用户不存在或密码错误
            session.setAttribute("isLogin",false);
            response.setStatus(403);
            Cookie cookie = new Cookie("Account","NULL");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return gson.toJson("USER NOT FOUND OR INCORRECT PASSWORD");
        }else if(userService.GetUserPassword(userData).equals(userData.getUserPassword())){
    //  登录成功
            session.setAttribute("USER_SESSION",userData);
            Cookie cookie = new Cookie("Account",userService.GetUserName(userData));
    //  cookies保存3600s, 也就是1小时后需要重新登录
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            response.addCookie(cookie);
            return gson.toJson("SUCCESS");
        }else {
            response.setStatus(403);
            return gson.toJson("?");
        }
    }
    //  忘记密码
    @RequestMapping(value = "forgot",method = RequestMethod.POST)
    public String forgot(@RequestBody UserData userData){
        Gson gson = new Gson();
    //  通过账号取得用户名
        String UserName = userService.GetUserName(userData);
    //  比对邮箱绑定的用户名
        String UserName1 = userService.GetUserNameByUserEmail(userData);
        if(UserName.equals(UserName1)){
    //  比对一致后从数据库获取原始用户信息后修改密码
            UserData userData1 = userService.GetUserByUserAccount(userData.getUserAccount());
            userData1.setUserPassword(userData.getUserPassword());
            userService.UpdateUser(userData1);
            return gson.toJson("SUCCESS");
        }else {
            return gson.toJson("FAILED");
        }
    }
}
