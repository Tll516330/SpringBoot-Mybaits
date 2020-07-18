package cn.tll.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/7/18 21:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String gender;
    private String address;
}
