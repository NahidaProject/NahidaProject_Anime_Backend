package NahidaProject.Anime.service.impl;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.mapper.UserMapper;
import NahidaProject.Anime.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<UserData> GetAllUsers(){
        List<UserData>  userDataList;
        userDataList = userMapper.GetUsersList();
        return userDataList;
    }
    @Override
    public boolean NewUser(UserData userData){
        int x = userMapper.NewUser(userData);
        return x > 0;
    }
    @Override
    public void DeleteUser(int UserID){
        userMapper.DeleteUser(UserID);
    }
    @Override
    public boolean UpdateUser(UserData userData){
        int x = userMapper.UpdateUser(userData);
        return x > 0;
    }
    @Override
    public String GetUserPassword(UserData userData){
        return userMapper.GetUserPassword(userData);
    }
    @Override
    public String GetUserName(UserData userData){
        return userMapper.GetUserName(userData);
    }
    @Override
    public String GetUserNameByUserEmail(UserData userData){return userMapper.GetUserNameByUserEmail(userData);}
    @Override
    public UserData GetUserByUserAccount(String userData){return userMapper.GetUserByUserAccount(userData);}
    @Override
    public boolean Certification(UserData userData) {
        return userData.getUserPassword().equals(GetUserPassword(userData));
    }
    @Override
    public boolean ResetPassword(UserData userData) {
        //  通过账号取得用户名   比对邮箱绑定的用户名
        if(GetUserName(userData).equals(GetUserNameByUserEmail(userData))){
            //  比对一致后从数据库获取原始用户信息后修改密码
            UserData userData1 = GetUserByUserAccount(userData.getUserAccount());
            userData1.setUserPassword(userData.getUserPassword());
            return UpdateUser(userData1);
        } else {
            return false;
        }

    }
    @Override
    public int GetUserIDByUserAccount(String userAccount) {
        return userMapper.GetUserByUserAccount(userAccount).getUserID();
    }
}
