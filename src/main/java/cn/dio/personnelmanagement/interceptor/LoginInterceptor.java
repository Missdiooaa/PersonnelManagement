package cn.dio.personnelmanagement.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object username = request.getSession().getAttribute("username");
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        if (requestURI != "/login" && requestURI != "/" && username == null) {
            request.setAttribute("error_msg", "has not login");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }

        return true;
    }
}
