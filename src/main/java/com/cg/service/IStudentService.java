package com.cg.service;

import com.cg.dao.StudentDAO;
import com.cg.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    List<StudentDAO> findAllProduct();

    void deleteId(String id);

    boolean create(Student student);

    Student findById(int userId);

    boolean update(Student student );


    List<StudentDAO> searchStudent(String keyword);
}
