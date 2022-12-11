package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public List<UserData> GetAllUsers(){
        return userMapper.GetUsersList();
    }

    public boolean NewUser(UserData userData){
        int x = userMapper.NewUser(userData);
        return x > 0;
    }

    public void DeleteUser(int UserID){
        userMapper.DeleteUser(UserID);
    }

    public boolean UpdateUser(UserData userData){
        int x = userMapper.UpdateUser(userData);
        return x > 0;
    }

    public String GetUserPassword(UserData userData){
        return userMapper.GetUserPassword(userData);
    }
    public String GetUserName(UserData userData){
        return userMapper.GetUserName(userData);
    }
    public String GetUserNameByUserEmail(UserData userData){return userMapper.GetUserNameByUserEmail(userData);}
    public UserData GetUserByUserAccount(UserData userData){return userMapper.GetUserByUserAccount(userData);}
}
