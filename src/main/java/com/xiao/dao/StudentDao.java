package com.xiao.dao;

import com.xiao.domain.Student;
import com.xiao.vo.StudentAndClassroomVo;

import java.util.List;
import java.util.Map;

/**
 * @author  XiaoHan
 * @date  2020/7/8 16:50
 * @version 1.0
 */
public interface StudentDao {

    Student getById(Integer id);

    void save(Student student);

    List<Student> selectStudent(Student student);

    List<Student> selectForeach(String[] arr);

    /*
     * 查询出学生姓名和班级名称*/

    List<Map<String,Object>> selectStudentClass();


    List<StudentAndClassroomVo>  selectStudentClassAllInfo();

    List<StudentAndClassroomVo> selectAllWherez(String name);
}
