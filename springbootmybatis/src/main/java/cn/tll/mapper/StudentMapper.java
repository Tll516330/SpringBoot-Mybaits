package cn.tll.mapper;

import cn.tll.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/7/18 21:14
 */
@Repository
@Mapper
public interface StudentMapper {
    /**
     * 获取所有学生的信息
     * @return
     */
    List<Student> getAllStudent();

    /**
     * 根据用户id查询学生信息
     * @return
     */
    Student getStudentById(int id);

    /**
     * 添加学生信息
     * @param student
     */
    void addStudent(Student student);

    /**
     * 根据id更新学生信息
     * @param id
     */
    void updateStuById(Student student);

    /**
     * 根据id删除学生信息
     * @param id
     */
    void deleteStuById(int id);
}
