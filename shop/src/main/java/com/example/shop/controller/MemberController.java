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
//        return "memberView";
        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String list(Model model){

        List<Member> memberList =  memberService.getMembers();

        model.addAttribute("members",memberList);
        return "memberList";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam String id, Model model){
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "memberUpdateForm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Member member){
        memberService.updateMember(member);

        return "redirect:/member/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id){
        memberService.deleteMember(id);
        return "redirect:/member/list";
    }
}
