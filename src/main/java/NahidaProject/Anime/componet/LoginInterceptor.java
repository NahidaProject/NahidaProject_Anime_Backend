package NahidaProject.Anime.componet;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@ServletComponentScan
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        用户登录之前不发送Session
        request.getSession(false);
//        处理预请求
        if(request.getMethod().equalsIgnoreCase("OPTIONS")){
            return true;
        }
//        主站请求serverStatus拦截登录状态
        if(request.getRequestURL().toString().equals("http://localhost:1314/api/serverStatus")){
            Cookie[] cookies =  request.getCookies();
//            cookies需携带JSESSIONID和Account
            if(cookies==null){
                handleResponse(response);
                return false;
            }else if(cookies.length==2) {
                HttpSession httpSession = request.getSession();
                Object userData = httpSession.getAttribute("USER_SESSION");
                if(userData!=null){
                    return true;
                }else {
                    handleResponse(response);
                    return false;
                }
            }else {
                handleResponse(response);
                return false;
            }
        }else {
            return true;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
    }
    private void handleResponse(HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson("NOT LOGIN YET"));
        response.setStatus(503);
        response.getWriter().flush();
    }
}
