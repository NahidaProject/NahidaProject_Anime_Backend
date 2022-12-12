package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.AdminData;
import NahidaProject.Anime.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

@Service
public class AdminService {
    @Resource
    AdminMapper adminMapper;
    public boolean AdminLogin(AdminData adminData){
        return adminMapper.AdminLoginByAccount(adminData.getAdminAccount()).equals(adminData.getAdminPassword());
    }

    public boolean AdminRegister(AdminData adminData){
        int x = adminMapper.AdminRegister(adminData);
        return x > 0;
    }

    public String GetAdminName(String AdminAccount){
        return adminMapper.GetAdminNameByAccount(AdminAccount);
    }

    public int GetAdminIDByAccount(String AdminAccount){return adminMapper.GetAdminIDByAccount(AdminAccount);}
}
