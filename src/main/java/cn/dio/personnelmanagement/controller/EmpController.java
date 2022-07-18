package cn.dio.personnelmanagement.controller;

import cn.dio.personnelmanagement.bean.Department;
import cn.dio.personnelmanagement.bean.Emp;
import cn.dio.personnelmanagement.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @RequestMapping("/emp/conditionalEmp")
    public Map list(Model model,
                    @RequestParam(value = "pn") Integer pageNum) {

        PageHelper.startPage(pageNum, 10);
        List<Emp> empList = empService.getAllEmp();
        PageInfo<Emp> page = new PageInfo<>(empList, 5);

        Department department = new Department(1, "犯罪部");
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);

        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "is200");

        Map extend = new HashMap();
        extend.put("pages", page);
        extend.put("department", departmentList);
        map.put("extend", extend);

        return map;
    }

    @RequestMapping("/emp/isExistEmp")
    public Map isExistEmp(@RequestParam("empName") String empName) {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "is200");
        return map;
    }

    @PutMapping("/emp")
    public Map addEmp(Emp emp) {

        empService.insertEmp(emp);

        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "is200");

        return map;
    }

    @RequestMapping("/deps")
    public Map getDepament() {

        Department department = new Department(1, "犯罪部");
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);

        Map extend = new HashMap();
        extend.put("department", departmentList);

        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "is200");
        map.put("extend", extend);

        return map;
    }
}
