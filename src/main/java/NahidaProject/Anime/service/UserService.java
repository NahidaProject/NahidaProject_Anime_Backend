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
            if(u1.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean Register(UserData userData){
        int x = mapper.addUser(userData.getUsername(),userData.getPassword(),userData.getRole());
        if(x>0){
            return true;
        }else {
            return false;
        }
    }
}
