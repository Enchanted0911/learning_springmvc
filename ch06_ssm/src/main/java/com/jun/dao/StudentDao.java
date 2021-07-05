package com.jun.dao;

import com.jun.domain.Student;

import java.util.List;

/**
 * @author Wu
 */
public interface StudentDao {
    /**
     * 老样子
     * @param student same old
     * @return 查询结果呗
     */
    int insertStudent(Student student);

    /**
     * same old
     * @return 学生集合呗
     */
    List<Student> selectStudents();
}
