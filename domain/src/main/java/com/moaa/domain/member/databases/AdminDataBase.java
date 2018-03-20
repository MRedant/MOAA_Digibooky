package com.moaa.domain.member.databases;

import com.moaa.domain.member.Admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminDataBase {

    private List<Admin> adminList;

    public AdminDataBase() {
        this.adminList = new ArrayList<>();
    }

    public List<Admin> getAdminList() {
        return Collections.unmodifiableList(adminList);
    }
}
