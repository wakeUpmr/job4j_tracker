package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает сущность пользователя - пасопрт и фамилия.
 * @author EGOR KRIVONOS
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     * Конструктор по всем полям класса.
     * @param passport - паспорт пользователя
     * @param username - фамилия пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер поля passport
     * @return паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер поля passport
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер поля username
     * @return фамилия пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер поля username
     * @param username фамилия пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals() по полю passport
     * @param o второй объект сранения
     * @return true или false - результат сравнения объектов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hashCode() по полю passport
     * @return hashCode по полю passport
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
