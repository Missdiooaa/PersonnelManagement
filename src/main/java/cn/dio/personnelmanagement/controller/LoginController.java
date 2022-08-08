package cn.dio.personnelmanagement.controller;

import cn.dio.personnelmanagement.bean.Emp;
import cn.dio.personnelmanagement.bean.User;
import cn.dio.personnelmanagement.service.EmpService;
import cn.dio.personnelmanagement.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping({"/login"})
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session) {
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.getAllUser();
        for (User user :
                userList) {
            if (user.getUsername().equals(username) || user.getPassword().equals(password)) {
                System.out.println("登录成功");
                session.setAttribute("username", username);
                mv.setViewName("list");
                return mv;
            }
        }
        if (session.getAttribute("username") == null) {
            mv.addObject("error_msg", "login_error");
            mv.setViewName("index");
        }

        return mv;
    }

    @RequestMapping("/list")
    public String list(Model model, HttpSession session, HttpServletRequest request) {
//        PageHelper.startPage(1, 10);
//        List<Emp> empList = empService.getAllEmp();
//        PageInfo<Emp> page = new PageInfo<>(empList, 5);
//        System.out.println(page);
//        model.addAttribute("page", page);
        ServletContext context = session.getServletContext();
        System.out.println(context.getContextPath());
        System.out.println(context.getServletContextName());
        System.out.println(context.getVirtualServerName());
        System.out.println(request.getPathInfo());
        String[] IP_SOURCE = {"WL-Proxy-Client-IP", "X-Real-IP", "X-Forwarded-For", "Proxy-Client-IP"};
        Arrays.asList(IP_SOURCE).forEach(source -> {
            System.out.println(request.getHeader(source));
        });
        System.out.println(request.getRemoteAddr());
        return "list";
    }

    @RequestMapping("/test_error")
    public String testError() {
        int i = 10 / 0;
        return "list";
    }
}
