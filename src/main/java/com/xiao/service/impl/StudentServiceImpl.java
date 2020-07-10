package com.xiao.service.impl;

import com.xiao.dao.StudentDao;
import com.xiao.domain.Student;
import com.xiao.service.StudentService;
import com.xiao.util.SqlSessionUtil;

/**
 * @author  XiaoHan
 * @date  2020/7/8 18:21
 * @version 1.0
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);

    @Override
    public Student getById(Integer id) {
        Student student = studentDao.getById(id);
        return student;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
        
    }
}
