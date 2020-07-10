package com.xiao.test;

import com.xiao.domain.Student;
import com.xiao.service.StudentService;
import com.xiao.service.impl.StudentServiceImpl;
import com.xiao.util.ServiceFactory;

/**
 * @author  XiaoHan
 * @date  2020/7/8 18:55
 * @version 1.0
 */
public class Tset {
    public static void main(String[] args) {

        //StudentService ss = new StudentServiceImpl();


        StudentService ss =(StudentService) ServiceFactory.getService(new StudentServiceImpl());
        System.out.println(ss);
        Student s = new Student();
        s.setAge(25);
        s.setId(1009);
        s.setName("孙权");
        s.setEmail("sunquan@163.com");
        ss.save(s);


    }

}
