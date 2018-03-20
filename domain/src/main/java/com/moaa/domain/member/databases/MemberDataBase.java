package com.moaa.domain.member.databases;

import com.moaa.domain.member.Member;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class MemberDataBase {

    private List<Member> memberList;

    public MemberDataBase() {
        this.memberList = new ArrayList<>();
    }

    public List<Member> getMemberList() {
        return Collections.unmodifiableList(memberList);
    }

    public void addMember(Member member) {
        memberList.add(member);
    }
}
