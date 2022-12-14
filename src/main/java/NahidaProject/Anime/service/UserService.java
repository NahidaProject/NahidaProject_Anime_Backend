package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.mapper.UserMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public List<UserData> GetAllUsers(){
        List<UserData>  userDataList;
        userDataList = userMapper.GetUsersList();
        return userDataList;
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
    public UserData GetUserByUserAccount(String userData){return userMapper.GetUserByUserAccount(userData);}
    public boolean Certification(UserData userData) {
        return userData.getUserPassword().equals(GetUserPassword(userData));
    }
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
    public int GetUserIDByUserAccount(String userAccount) {
        return userMapper.GetUserByUserAccount(userAccount).getUserID();
    }
}
