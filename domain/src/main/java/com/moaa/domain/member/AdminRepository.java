package com.moaa.domain.member;

import com.moaa.domain.member.databases.AdminDataBase;

import javax.inject.Named;

@Named
public class AdminRepository {

    private AdminDataBase adminDataBase;

    public AdminRepository(AdminDataBase adminDataBase) {
        this.adminDataBase = adminDataBase;
    }

    public Admin createAdmin (){
        return null;
    }

    public Admin getAdmin (){
        return null;
    }

    public Admin updateAdmin (){
        return null;
    }

    public Admin deleteAdmin (){
        return null;
    }
}
