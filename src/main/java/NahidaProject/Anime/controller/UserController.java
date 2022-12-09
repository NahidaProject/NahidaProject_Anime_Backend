package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.service.UserService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/api/user")
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
}
