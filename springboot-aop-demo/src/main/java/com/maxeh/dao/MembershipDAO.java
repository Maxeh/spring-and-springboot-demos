package com.maxeh.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAO {
    private int credit = 100;

    public int addAccount() {
        System.out.println("Member account added. \n --- \n");
        return 1;
    }

    public void getCredit() {
        System.out.println("Credit:" + credit);
    }
}
