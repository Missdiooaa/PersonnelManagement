package cn.dio.personnelmanagement.controller;

import cn.dio.personnelmanagement.bean.Emp;
import cn.dio.personnelmanagement.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    EmpService empService;

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
        String[] IP_SOURCE={"WL-Proxy-Client-IP","X-Real-IP","X-Forwarded-For","Proxy-Client-IP"};
        Arrays.asList(IP_SOURCE).forEach(source -> {
            System.out.println(request.getHeader(source));
        });
        System.out.println(request.getRemoteAddr());
        return "list";
    }
}
