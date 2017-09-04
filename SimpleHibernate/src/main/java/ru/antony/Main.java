package ru.antony;

import ru.antony.logic.Student;
import ru.antony.service.StudentService;
import ru.antony.service.impl.StudentServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class Main {

    private static StudentService studentService;

    public static void main(String[] args) throws SQLException {

        //Locale currentLocale = Locale.getDefault();

        // Создадим двух студентов
        Student s1 = new Student();
        Student s2 = new Student();

        //Проинициализируем их
        s1.setName("Ivanov Ivan");
        s1.setAge(21l);
        s2.setName("Petrova Alisa");
        s2.setAge(24l);

        Locale.setDefault(Locale.ENGLISH);
        studentService = new StudentServiceImpl();

        //Сохраним их в бд, id будут сгенерированы автоматически
        studentService.addStudent(s1);
        studentService.addStudent(s2);

        // Выведем всех студентов из бд
        List<Student> studs = studentService.getAllStudents();
        System.out.println("========Все студенты=========");
        for(int i = 0; i < studs.size(); ++i) {
            System.out.println("Имя студента : " + studs.get(i).getName() + ", Возраст : " + studs.get(i).getAge() +",  id : " + studs.get(i).getId());
            System.out.println("=============================");
        }

        //Locale.setDefault(currentLocale);
    }
}