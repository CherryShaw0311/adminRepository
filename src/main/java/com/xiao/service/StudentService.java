package com.xiao.service;

import com.xiao.domain.Student;

/**
 * @author  XiaoHan
 * @date  2020/7/8 18:20
 * @version 1.0
 */
public interface StudentService {
    Student getById(Integer id);

    void save(Student student);
}
