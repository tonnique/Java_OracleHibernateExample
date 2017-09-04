package ru.antony.logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query="select s from Student s"),
        @NamedQuery(name = "Student.findById", query="select distinct s from Student s where s.id = :id")
})
public class Student {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Long age;

    //public Set<Student> st = new HashSet<Student>();

    public Student(){}

    public Student(Student s){
        name = s.getName();
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getName(){
        return name;
    }

    public void setName(String s){
        name = s;
    }

    public Long getAge(){
        return age;
    }

    public void setAge(Long a){
        age = a;
    }
}
