package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.AdminData;

public interface AdminService {
    boolean AdminLogin(AdminData adminData);
    boolean AdminRegister(AdminData adminData);
    String GetAdminName(String AdminAccount);
    int GetAdminIDByAccount(String AdminAccount);
}
