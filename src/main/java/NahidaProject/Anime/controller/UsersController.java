package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/api/users")
public class UsersController {
    @Resource
    UserService userService;

    @RequestMapping("/getAllUsers")
    public List<UserData> getUserList(){
        List<UserData> userDataList;
        userDataList = userService.findAllUsers();
        return userDataList;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    private void register(@RequestBody UserData userData,HttpServletResponse response) throws IOException {
        boolean flag = userService.Register(userData);
        if(flag){
            response.getWriter().print("Success");
            response.setStatus(200);
        }else {
            response.getWriter().print("userDuplicated");
            response.setStatus(400);
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    private void login(@RequestBody UserData userData,HttpServletResponse response) throws IOException {
        boolean flag = userService.Login(userData);
        if(flag){
            response.getWriter().print("Success");
            response.setStatus(200);
        }else {
            response.getWriter().print("userDuplicated");
            response.setStatus(400);
        }
    }

    @Data
    class UserModify extends UserData{
        String currentUser;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    private void update(@RequestBody UserModify userModify,HttpServletResponse response) throws IOException {
        UserData cu = userService.findUserByName(userModify.getCurrentUser());
        if(!Objects.equals(cu.getRole(), "Admin")){
            response.getWriter().print("Fail");
            response.setStatus(400);
        }else {
            UserData userData = new UserData();
            userData.setId(userModify.getId());
            userData.setUsername(userModify.getUsername());
            userData.setPassword(userModify.getPassword());
            userData.setRole(userModify.getRole());
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

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    private void del(@RequestBody UserModify userModify,HttpServletResponse response) throws IOException {
        UserData cu = userService.findUserByName(userModify.getCurrentUser());
        if(!Objects.equals(cu.getRole(), "Admin")){
            response.getWriter().print("Fail");
            response.setStatus(400);
        }else {
            UserData userData = new UserData();
            userData.setUsername(userModify.getUsername());
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
