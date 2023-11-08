package org.korit.restcontrollers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.korit.entities.Member;
import org.korit.repositories.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
@Slf4j
public class ApiMemberController {

    private final MemberRepository repository;

    @GetMapping("/{userId}")
    public Member info(@PathVariable String userId){
        Member member = repository.findByUserId(userId);


        return member;
    }

    @GetMapping("/list")
    public List<Member> list(){
        List<Member> members = (List<Member>) repository.findAll();

        return members;
    }

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요";
    }

    @GetMapping("/test")
    public void test() {
        log.info("안녕하세요");
    }

    public void login(RequestLogin form) {
        log.info(form.toString());
    }
}
