package org.korit.controllers;

import lombok.RequiredArgsConstructor;
import org.korit.entities.Member;
import org.korit.repositories.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final MemberRepository repository;
    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }

    @ResponseBody
    @GetMapping("/info/{userId}")
    public Member info(@PathVariable String userId){
        Member member = repository.findByUserId(userId);
        return member;
    }
}
