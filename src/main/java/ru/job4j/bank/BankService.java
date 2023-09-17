package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает функционал работы с пользователями, их аккаунтами (поиск, удаление, добавление,
 * перевод денег).
 * @author EGOR KRIVONOS
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и их аккаунтов осуществляется в коллекции HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в карту.
     * @param user пользователь, который добаваляется в карту
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает паспорт пользователя и удаляет соответсвующего пользователя из карты.
     * @param passport паспорт пользователя
     * @return сравнение с null (если возвращенный методом remove объект был не null, значит
     * объект был успешно удален)
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает пасопрт пользователя и его аккаунт.
     * Если пользователь был найден и его аккаунт не был добавлен,
     * происходит добавление аккаунта.
     * @param passport паспорт пользователя
     * @param account аккаунт пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает паспорт пользователя.
     * @param passport паспорт пользователя
     * @return объект типа User соответсвующего пользователя по паспорту
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает паспорт пользователя и его реквизит.
     * Если пользователь был найден по паспорту, происходит дальнейший поиск
     * по реквизиту пользователя.
     * @param passport паспорт пользователя
     * @param requisite реквизит пользователя
     * @return объект типа Account соответсвующего пользователя по реквизиту счета
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(r -> requisite.equals(r.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег с одного счета на другой.
     * Если пользователь-отправитель и пользователь принимающий платеж были найдены
     * и сумма денег на счету отправителя больше суммы перевода, происходит изменение их балансов:
     * у отпрвителя снимается сумма перевода, у адресата пополняется.
     * @param srcPassport паспорт пользователя-отправителя
     * @param srcRequisite реквизит пользователя-отправителя
     * @param destPassport пасспорт пользователя адресата
     * @param destRequisite реквизит пользователя адресата
     * @param amount сумма перевода
     * @return true или false - результат перевода денег с одного счета на другой
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }

    /**
     * Метод принимает пользователя и возвращает список его аккаунтов
     * @param user пользователь
     * @return список аккаунтов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}