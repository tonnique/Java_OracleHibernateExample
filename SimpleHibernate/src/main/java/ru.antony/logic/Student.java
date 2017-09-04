package ru.antony.logic;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student")
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
