package cn.tll.controller;

import cn.tll.mapper.StudentMapper;
import cn.tll.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/7/18 23:17
 */
@RequestMapping("/tll")
@RestController
public class StudentController {

    @Autowired
    StudentMapper mapper;
    /**
     * 查询所有学生信息
     * @return
     */
    @RequestMapping("/getAllStu")
    public List<Student> getAllStu(){
        return mapper.getAllStudent();
    }

    /**
     * 通过id查询学生
     * @param id
     * @return
     */
    @RequestMapping("/getStuById/{id}")
    public Student getStuById(@PathVariable(name = "id") Integer id){
        Student student = mapper.getStudentById(id);
        return student;
    }

    /**
     * 添加学生信息
     * @return
     */
    @RequestMapping("/addStudent")
    public String addStudent(){
        Student student = new Student();
        student.setName("腾讯");
        student.setGender("男");
        student.setAddress("深圳");
        mapper.addStudent(student);
        return "添加学生信息成功";
    }

    /**
     * 更新学生信息
     * @param id
     * @return
     */
    @RequestMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable(name = "id")Integer id){
        Student student = new Student();
        student.setName("马云");
        student.setGender("男");
        student.setAddress("杭州");
        student.setId(id);
        mapper.updateStuById(student);
        return "更新成功";
    }

    @RequestMapping("/delete/{id}")
    public String deleteStuById(@PathVariable(name = "id")Integer id){
        mapper.deleteStuById(id);
        return "删除成功";
    }
}
