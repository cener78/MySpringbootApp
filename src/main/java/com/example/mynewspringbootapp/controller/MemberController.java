package com.example.mynewspringbootapp.controller;


import com.example.mynewspringbootapp.model.Member;
import com.example.mynewspringbootapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    public  MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members")
    public List<Member> findAllMember(){
        return memberService.fetchAllMembers();
    }

    @PostMapping(path = "/members/add")
    public Member addMember(@RequestBody Member newMember){
         return memberService.addNewMember(newMember);
}
    @DeleteMapping(path="/members/delete/{id}")
    public String deleteMemberById(@PathVariable  Integer id) {
        return memberService.removeMemberById(id);
    }
    @PutMapping(path="/members/update")
    public Member updatePerson( @RequestBody Member member) {

        return memberService.updateMember(member);
    }


    @PatchMapping("/members/update/{id}")
    public Member updateMember(@PathVariable Integer id, @RequestBody Member updatedMember) {

        return memberService.updateMemberById(id, updatedMember);
    }


}
