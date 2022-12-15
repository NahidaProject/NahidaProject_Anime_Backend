package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.UserData;

import java.util.List;

public interface UserService {
    List<UserData> GetAllUsers();
    boolean NewUser(UserData userData);
    void DeleteUser(int UserID);
    boolean UpdateUser(UserData userData);
    String GetUserPassword(UserData userData);
    String GetUserName(UserData userData);
    String GetUserNameByUserEmail(UserData userData);
    UserData GetUserByUserAccount(String userData);
    boolean Certification(UserData userData);
    boolean ResetPassword(UserData userData);
    int GetUserIDByUserAccount(String userAccount);
}
