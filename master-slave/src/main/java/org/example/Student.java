package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int rollno;
    private String sName;
    private int sAge;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
