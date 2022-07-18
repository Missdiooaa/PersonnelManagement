package cn.dio.personnelmanagement.mapper;

import cn.dio.personnelmanagement.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    public List<Emp> getAllEmp();

    public int insertEmp(Emp emp);
}
