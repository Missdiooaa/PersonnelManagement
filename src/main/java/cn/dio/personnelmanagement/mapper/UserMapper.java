package cn.dio.personnelmanagement.mapper;

import cn.dio.personnelmanagement.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAllUser();
}
