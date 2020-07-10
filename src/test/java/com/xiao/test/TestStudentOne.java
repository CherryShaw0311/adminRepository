package com.xiao.test;

import com.xiao.dao.StudentDao;
import com.xiao.domain.Student;
import com.xiao.service.StudentService;
import com.xiao.service.impl.StudentServiceImpl;
import com.xiao.util.ServiceFactory;
import com.xiao.util.SqlSessionUtil;
import com.xiao.vo.StudentAndClassroomVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author  XiaoHan
 * @date  2020/7/8 17:17
 * @version 1.0
 */
public class TestStudentOne {
    @Test
    public void testStudent(){
        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        Student s = new Student();
        s.setAge(28);
        s.setId(1013);
        s.setName("马谡");
        s.setEmail("mashu@163.com");

        ss.save(s);


    }
    @Test
    public void testGetById(){
        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        Student s = ss.getById(1004);
        System.out.println(s);
    }

    @Test
    public void testSelectStudent(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        //student.setEmail("@");
        student.setName("张");
        List<Student> studentList = dao.selectStudent(student);
        studentList.forEach(student1 -> System.out.println(student1));
    }

    @Test
    public void testForeach(){
        String[] arr = {"张飞","孙权"};
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectForeach(arr);
        studentList.forEach(student1 -> System.out.println(student1));
    }


    @Test
    public void testselectStudentClass(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Map<String,Object>> mapList = dao.selectStudentClass();
        for (Map<String,Object> map:mapList){
            Set<String> set = map.keySet();
            for (String key:set){
                System.out.println("key:"+key);
                System.out.println("value:"+map.get(key));
                System.out.println("----------------------");
            }
            System.out.println("========================================");
        }
    }


    @Test
    public void testselectStudentClassAllInfo(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<StudentAndClassroomVo> studentAndClassroomVoList = dao.selectStudentClassAllInfo();
        studentAndClassroomVoList.forEach(studentAndClassroomVo -> System.out.println(studentAndClassroomVo));
    }


    @Test
    public void testselectAllWherez(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<StudentAndClassroomVo> studentAndClassroomVoList = dao.selectAllWherez("马");
        studentAndClassroomVoList.forEach(studentAndClassroomVo -> System.out.println(studentAndClassroomVo));
    }






}
