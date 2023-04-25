package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Egor Krivonos");
        student.setGroup("RK6-21B");
        student.setAdmissionDate(new Date(1630472400000L));

        System.out.println("student - " + student.getName() + " from group "
                            + student.getGroup() + " was admitted to the university on "
                            + student.getAdmissionDate());
    }
}
