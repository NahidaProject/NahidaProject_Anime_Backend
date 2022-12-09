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
}
