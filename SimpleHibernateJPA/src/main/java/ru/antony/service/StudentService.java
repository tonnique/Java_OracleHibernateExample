package ru.antony.service;

import java.sql.SQLException;
import java.util.List;
import ru.antony.logic.Student;

public interface StudentService {
    public List<Student> findAll() throws SQLException;
    public Student findById(Long id) throws SQLException;
    public void delete(Student student) throws SQLException;
    public void updateStudent(Student stud) throws SQLException;
    public void addStudent(Student student) throws SQLException;
}

