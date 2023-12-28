package com.example.shop.controller;

import com.example.shop.domain.Member;
import com.example.shop.service.MemberService;
import jakarta.servlet.ServletOutputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/add")
    public String addForm(){
        return "memberForm";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Member member, Model model){
        memberService.joinMember(member);
        model.addAttribute("member", member);
        return "memberView";
    }

    @GetMapping("/list")
    public String list(Model model){

        List<Member> memberList =  memberService.getMembers();

        model.addAttribute("members",memberList);
        return "memberList";
    }


}
