package com.moaa.domain.member;

import com.moaa.domain.member.databases.MemberDataBase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.UUID;

@Named
public class MemberRepository {

    @Inject
    private MemberDataBase memberDataBase;

    public MemberRepository(MemberDataBase memberDataBase) {
        this.memberDataBase = memberDataBase;
    }

    public Member createMember (Member member){
        return memberDataBase.addMember(member);
    }

    public List<Member> getAllMembers (){
        return memberDataBase.getMemberList();
    }

    public Member updateMember (UUID memberUuid, Member newMember){
        return null;
    }

    public Member deleteMember (){
        return null;
    }
}
