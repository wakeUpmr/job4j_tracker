package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает сущность аккаунта пользователя - реквизит и его баланс.
 * @author EGOR KRIVONOS
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Конструктор по всем полям класса.
     * @param requisite - текущий реквизит счета.
     * @param balance - текущий баланс.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер поля requisite.
     * @return реквизит счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер поля requisite
     * @param requisite реквизит пользователя
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер поля balance
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер поля balance
     * @param balance баланс пользователя
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод equals() по полю requisite
     * @param o второй объект сравнения
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode()
     * @return hashCode по полю requisite
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(requisite);
    }
}
