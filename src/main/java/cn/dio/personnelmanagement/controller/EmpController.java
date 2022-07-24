package cn.dio.personnelmanagement.controller;

import cn.dio.personnelmanagement.bean.Department;
import cn.dio.personnelmanagement.bean.Emp;
import cn.dio.personnelmanagement.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/emp/isExistEmp")
    public Map isExistEmp(@RequestParam("name") String name) {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "is200");
        return map;
    }

    @PostMapping("/emp")
    public Map addEmp(Emp emp) {

        int i = empService.insertEmp(emp);
        if (i > 0) {
            System.out.println("增加成功，增加了{"+i+"}条数据");
        } else {
            System.out.println("增加失败！");
        }

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
        extend.put("departments", departmentList);

        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "is200");
        map.put("extend", extend);

        return map;
    }
}
