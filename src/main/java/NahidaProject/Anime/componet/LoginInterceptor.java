package NahidaProject.Anime.componet;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.utils.AccountInspection;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Slf4j
@ServletComponentScan
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//  放行预请求
        if(request.getMethod().equalsIgnoreCase("OPTIONS")){
            return true;
        }
        HttpSession httpSession = request.getSession();
//  论坛请求serverStatus以拦截登录状态
//  cookies需携带JSESSIONID和Account
        if(request.getRequestURL().toString().equals("http://localhost:1314/api/serverStatus")){
            UserData userDataSession = (UserData) httpSession.getAttribute("USER_SESSION");
            if(userDataSession==null||!new AccountInspection(userDataSession,request).LoginInspection()){
//  若无Session则告知用户未登录   前端跳转登录页
                return handleResponse(response);
            }
//  完整性校验通过后放行
            return true;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
    }
    private boolean handleResponse(HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson("NOT LOGIN YET"));
        response.setStatus(503);
        response.getWriter().flush();
        return false;
    }
}
