package com.example.mynewspringbootapp.service;

import com.example.mynewspringbootapp.model.Member;
import com.example.mynewspringbootapp.repository.MemberRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public static MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        MemberService.memberRepository=memberRepository;
    }
    public List<Member> fetchAllMembers(){
        return memberRepository.findAll();

    }

    public Member addNewMember(Member newMember){
        return memberRepository.save(newMember);
    }

    public String removeMemberById(Integer id ) {

        if(memberRepository.findById(id)==null) {

            throw new EmptyResultDataAccessException(id);
        }

        memberRepository.deleteById(id);
        return id + "th member was deleted";
    }
    public Member  updateMember (Member member) {

        return memberRepository.save(member);
    }

    //	//PATCH= bir kişinin istediğiniz field ını değiştirir, metodu yazarken kişiyi id si ile seçeriz belirtiriz
//
    public Member updateMemberById(Integer id, Member member) {

        Member oldMember=	memberRepository.findById(id).orElseThrow(()-> new IllegalStateException(id + " id not found"));

        if( member.getName()!=null) {
            oldMember.setName(member.getName());

        }

        if( member.getSurname()!=null) {
            oldMember.setSurname(member.getSurname());

        }

        if( member.getAge()!=0) {
            oldMember.setAge(member.getAge());

        }

        return	memberRepository.save(oldMember);


    }
}
