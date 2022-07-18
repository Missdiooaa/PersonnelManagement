package cn.dio.personnelmanagement.service;

import cn.dio.personnelmanagement.bean.Emp;
import cn.dio.personnelmanagement.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Emp> getAllEmp() {
        return empMapper.getAllEmp();
    }

    @Override
    public int insertEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }
}
