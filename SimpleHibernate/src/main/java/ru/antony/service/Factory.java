package ru.antony.service;

import ru.antony.service.impl.StudentServiceImpl;

public class Factory {

    private static StudentService studentService = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public StudentService getStudentDAO(){
        if (studentService == null){
            studentService = new StudentServiceImpl();
        }
        return studentService;
    }
}
