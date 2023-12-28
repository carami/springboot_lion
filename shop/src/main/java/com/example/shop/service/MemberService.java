package com.example.shop.service;

import com.example.shop.domain.Member;
import com.example.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void joinMember(Member member){
        //처리할 모든 비지니스는 여기에서....

        memberRepository.saveMember(member);
    }

    public List<Member> getMembers(){
        return memberRepository.getMembers();
    }

    public Member getMember(String id){
        return memberRepository.getMember(id);
    }

    public void updateMember(Member member){
        memberRepository.updateMember(member);
    }

    public void deleteMember(String id){
        memberRepository.deleteMember(id);
    }

}
