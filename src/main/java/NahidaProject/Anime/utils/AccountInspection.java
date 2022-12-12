package NahidaProject.Anime.utils;

import NahidaProject.Anime.entity.UserData;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountInspection {
    UserData sessionData;
    String cookieUserAccount;

    public AccountInspection(UserData sessionUserData, HttpServletRequest request) {
        this.sessionData = sessionUserData;
        this.cookieUserAccount = GetUserAccount(request);
    }

    public boolean LoginInspection(){
        if(this.sessionData.getUserAccount()!=null){
            return this.sessionData.getUserAccount().equals(this.cookieUserAccount);
        }else {
            log.warn("用户"+this.cookieUserAccount+"发起非法请求");
            return false;
        }
    }

    public String GetUserAccount(HttpServletRequest request){
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("Account")){
                    log.warn("用户"+cookie.getValue()+"请求登录");
                    return cookie.getValue();
                }
            }
        }
        return  null;
    }
}
