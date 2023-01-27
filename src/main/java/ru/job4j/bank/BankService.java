package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            List<Account> account = new ArrayList<>();
            users.put(user, account);
        }
    }

    public boolean deleteUser(String passport) {
        boolean rsl = false;
        if (users.containsKey(this.findByPassport(passport))) {
            users.remove(this.findByPassport(passport));
            rsl = true;
        }
        return rsl;
    }

    public void addAccount(String passport, Account account) {
        if (!users.get(this.findByPassport(passport)).contains(account)) {
            users.get(this.findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                for (Account account : users.get(user)) {
                    if (account.getRequisite().equals(requisite)) {
                        return account;
                    }
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (this.findByRequisite(srcPassport, srcRequisite) != null
            && this.findByRequisite(destPassport, destRequisite) != null
            && this.findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            this.findByRequisite(srcPassport, srcRequisite).setBalance(this.findByRequisite(srcPassport, srcRequisite).getBalance() - amount);
            this.findByRequisite(destPassport, destRequisite).setBalance(this.findByRequisite(destPassport, destRequisite).getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}