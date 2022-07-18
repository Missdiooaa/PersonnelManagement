package cn.dio.personnelmanagement;

import cn.dio.personnelmanagement.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonnelManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelManagementApplication.class, args);
    }

}
