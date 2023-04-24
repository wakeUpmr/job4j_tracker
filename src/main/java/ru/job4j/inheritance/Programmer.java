package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String programLang;

    public Programmer(int experience, boolean degree, String programLang) {
        super(experience, degree);
        this.programLang = programLang;
    }
}