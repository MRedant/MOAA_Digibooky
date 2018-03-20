package com.moaa.domain.member;

import com.moaa.domain.member.databases.MemberDataBase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MemberRepository {

    @Inject
    private MemberDataBase memberDataBase;

    public MemberRepository(MemberDataBase memberDataBase) {
        this.memberDataBase = memberDataBase;
    }

    public Member createMember (Member member){
        memberDataBase.addMember(member);
        return member;
    }

    public Member getMember (){
        return null;
    }

    public Member updateMember (){
        return null;
    }

    public Member deleteMember (){
        return null;
    }
}
