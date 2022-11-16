package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.mapper.MainMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    MainMapper mapper;

    public UserData findUserByName(String username){
        return mapper.findUserByName(username);
    }

    public boolean Login(UserData userData){
        String name = userData.getUsername();
        String password = userData.getPassword();
        UserData u1 =  mapper.findUserByName(name);
        if(u1==null){
            return false;
        }else{
            return u1.getPassword().equals(password);
        }
    }

    public boolean Register(UserData userData){
        int x = mapper.addUser(userData.getUsername(),userData.getPassword(),userData.getRole());
        return x > 0;
    }

    public boolean Delete(UserData userData){
        int x = mapper.delUser(userData.getUsername());
        return x > 0;
    }

    public boolean Update(UserData userData){
        int x = mapper.updateUser(userData.getId(),userData.getUsername(),userData.getPassword(),userData.getRole());
        return x > 0;
    }
}
