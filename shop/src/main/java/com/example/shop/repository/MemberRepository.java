package com.example.shop.repository;

import com.example.shop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MemberRepository {
    private static HashMap<String, Member> memberRepo = null;

    public MemberRepository(){
        memberRepo = new HashMap<>();
        Member kang = new Member("강경미","kang","1234","carami@nate.com","010-1111-2222");
        Member kim = new Member("김둘리","kim","1111","kim@kim.com","010-2222-2222");
                memberRepo.put(kang.getId(),kang);
                memberRepo.put(kim.getId(),kim);
    }

    private void printMembers(){
        memberRepo.forEach((key, value)->{
            System.out.println(key + ":::" + value);
        });
    }
    public void saveMember(Member member){
        memberRepo.put(member.getId(),member);
        printMembers();
    }

    public List<Member> getMembers(){
        return memberRepo.values().stream().toList();
    }

    public Member getMember(String id){
        return memberRepo.get(id);
    }

    public void updateMember(Member member){
        memberRepo.put(member.getId(),member);
    }

    public void deleteMember(String id){
        memberRepo.remove(id);
    }
}
