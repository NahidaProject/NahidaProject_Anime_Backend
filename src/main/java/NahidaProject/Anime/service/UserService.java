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

    public UserData findUserByName(String username){
        return userMapper.findUserByName(username);
    }

    public List<UserData> findAllUsers() {
        return userMapper.findAllUsers();
    }

    public boolean Login(UserData userData){
        String name = userData.getUsername();
        String password = userData.getPassword();
        UserData u1 =  userMapper.findUserByName(name);
        if(u1==null){
            return false;
        }else{
            return u1.getPassword().equals(password);
        }
    }

    public boolean Register(UserData userData){
        int x = userMapper.addUser(userData);
        return x > 0;
    }

    public boolean Delete(UserData userData){
        int x = userMapper.delUser(userData.getUsername());
        return x > 0;
    }

    public boolean Update(UserData userData){
        int x = userMapper.updateUser(userData.getId(),userData.getUsername(),userData.getPassword(),userData.getRole());
        return x > 0;
    }
}
