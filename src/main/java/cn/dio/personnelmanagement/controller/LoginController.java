package cn.dio.personnelmanagement.controller;

import cn.dio.personnelmanagement.bean.Emp;
import cn.dio.personnelmanagement.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    EmpService empService;

    @RequestMapping("/list")
    public String list(Model model) {
//        PageHelper.startPage(1, 10);
//        List<Emp> empList = empService.getAllEmp();
//        PageInfo<Emp> page = new PageInfo<>(empList, 5);
//        System.out.println(page);
//        model.addAttribute("page", page);
        return "list";
    }
}
