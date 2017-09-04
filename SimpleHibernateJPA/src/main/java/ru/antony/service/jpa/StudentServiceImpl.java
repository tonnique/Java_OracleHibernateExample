package ru.antony.service.jpa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import ru.antony.logic.Student;
import ru.antony.service.StudentService;


public class StudentServiceImpl implements StudentService {
    private EntityManager em = Persistence.createEntityManagerFactory("student").createEntityManager();

    public void addStudent(Student stud) throws SQLException {
        try {
            em.getTransaction().begin();
            em.persist(stud);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }
    }

    public void updateStudent(Student stud) throws SQLException {

        try {
            em.getTransaction().begin();
            em.refresh(stud);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }
    }

    public Student findById(Long id) throws SQLException {
        Student stud = null;

        try {
            stud = (Student) em.createNamedQuery("Student.findById", Student.class).getSingleResult();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }
        return stud;
    }

    public List<Student> findAll() throws SQLException {

        List<Student> studs = new ArrayList<Student>();
        try {
            studs = em.createNamedQuery("Student.findAll", Student.class).getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }
        return studs;
    }

    public void delete(Student stud) throws SQLException {
        try {
            em.getTransaction().begin();
            em.remove(stud);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }
    }
}
