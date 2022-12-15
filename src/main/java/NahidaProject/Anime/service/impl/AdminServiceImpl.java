package NahidaProject.Anime.service.impl;

import NahidaProject.Anime.entity.AdminData;
import NahidaProject.Anime.mapper.AdminMapper;
import NahidaProject.Anime.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;
    @Override
    public boolean AdminLogin(AdminData adminData){
        return adminMapper.AdminLoginByAccount(adminData.getAdminAccount()).equals(adminData.getAdminPassword());
    }
    @Override
    public boolean AdminRegister(AdminData adminData){
        int x = adminMapper.AdminRegister(adminData);
        return x > 0;
    }
    @Override
    public String GetAdminName(String AdminAccount){
        return adminMapper.GetAdminNameByAccount(AdminAccount);
    }
    @Override
    public int GetAdminIDByAccount(String AdminAccount){return adminMapper.GetAdminIDByAccount(AdminAccount);}
}
