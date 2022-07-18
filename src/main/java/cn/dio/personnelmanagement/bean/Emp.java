package cn.dio.personnelmanagement.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp {

    private int id;
    private String name;
    private String sex;
    private String email;
    private String deptname;

}
