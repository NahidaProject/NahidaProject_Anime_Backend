package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.AdminData;
import NahidaProject.Anime.service.AdminService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@ResponseBody
@RequestMapping("/api/admin")
public class AdminController {
    @Resource
    AdminService adminService;
    //    管理平台管理员登录接口
    @RequestMapping(value = "/admin_login",method = RequestMethod.POST)
    private String login(@RequestBody AdminData adminData, HttpServletResponse response){
        boolean flag = adminService.AdminLogin(adminData);
        Gson gson = new Gson();
        if(flag){
            response.setStatus(200);
            return gson.toJson("SUCCESS");
        }else {
            response.setStatus(400);
            return gson.toJson("ACCOUNT NOT FOUND");
        }
    }
    //    管理平台管理员注册接口
    @RequestMapping(value = "/admin_register",method = RequestMethod.POST)
    private String register(@RequestBody AdminData adminData,HttpServletResponse response){
        Gson gson = new Gson();
        if(adminService.AdminRegister(adminData)){
            response.setStatus(200);
            return gson.toJson("SUCCESS");
        }else {
            response.setStatus(400);
            return gson.toJson("ACCOUNT DUPLICATION");
        }
    }
    //    管理平台获取管理员昵称接口
    @RequestMapping(value = "{account}",produces = "application/json;charset=UTF-8")
    private String getName(HttpServletResponse response, @PathVariable String account) {
        response.setStatus(200);
        Gson gson = new Gson();
        return gson.toJson(adminService.GetAdminName(account));
    }
}
