package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простого банковского сервиса
 * @author Igor Bielogolovski
 */
public class BankService {
    /**
     * Хранение информации о пользователях банка и их счетах
     * осуществляется в коллекции типа Map<User, List<Account></Account>
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию, если его там еще нет
     * @param user пользователь, которого добавляют в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя с заданным паспортом из коллекции, если он там был
     * @param passport паспорт пользователя, которого необходимо удалить
     * @return возвращает true, если пользователь успешно удален и false, если нет
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * метод добавляет заданный счет пользователю с заданным паспортом
     * @param passport паспорт пользователя, которому необходимо добавить счет
     * @param account счет, который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    /**
     * Метод ищет пользователя с заданным паспортом
     * @param passport паспорт пользователя, которого необходимо найти
     * @return пользователя с заданным паспортом или null, если не удалось его найти
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет по заданным паспорту и реквизиту
     * @param passport паспорт пользователя, счет которого необходимо найти
     * @param requisite реквизит счета, который необходимо найти
     * @return счет с заданным реквизитом или null, если не удалось его найти
     */
    public Account findByRequisite(String passport, String requisite) {
        return users.get(findByPassport(passport)).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод переводит деньги с одного счета на другой
     * @param srcPassport паспорт пользователя, который переводит деньги
     * @param srcRequisite реквизит счета, с которого переводят деньги
     * @param destPassport паспорт пользователя, которому переводят деньги
     * @param destRequisite реквизит счета, на который переводят деньги
     * @param amount сумма перевода
     * @return возвращает true, если перевод успешный и false, если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
            && destAccount != null
            && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}