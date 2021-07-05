package com.jun.service;

import com.jun.domain.Student;

import java.util.List;

/**
 * @author Wu
 */
public interface StudentService {
    /**
     * 好烦，又要写，别问了，老样子，添加学生
     * @param student 要添加的学生
     * @return 添加是否成功
     */
    int addStudent(Student student);

    /**
     * 老样子唉
     * @return 查询的学生结果
     */
    List<Student> findStudents();
}
