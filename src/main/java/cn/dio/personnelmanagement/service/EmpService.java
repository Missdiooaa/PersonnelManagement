package cn.dio.personnelmanagement.service;

import cn.dio.personnelmanagement.bean.Emp;

import java.util.List;

public interface EmpService {

    public List<Emp> getAllEmp();

    public int insertEmp(Emp emp);
}
