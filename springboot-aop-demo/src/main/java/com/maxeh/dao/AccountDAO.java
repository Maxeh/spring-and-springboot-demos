package com.maxeh.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    public void addAccount() {
        System.out.println("Account was added. \n --- \n");
    }

    public void deleteAccount() {
        System.out.println("Account was deleted \n --- \n");
    }
}
