package com.moaa.domain.member.databases;

import com.moaa.domain.member.Member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemberDataBase {

    private List<Member> memberList;

    public MemberDataBase() {
        this.memberList = new ArrayList<>();
    }

    public List<Member> getMemberList() {
        return Collections.unmodifiableList(memberList);
    }
}
