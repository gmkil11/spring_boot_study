package org.korit.restcontrollers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.korit.commons.BadRequestException;
import org.korit.commons.CommonException;
import org.korit.commons.JSONData;
import org.korit.entities.Member;
import org.korit.repositories.MemberRepository;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
@Slf4j
public class ApiMemberController {

    private final MemberRepository repository;

    @GetMapping("/{userId}")
    public ResponseEntity<JSONData<Member>> info(@PathVariable String userId){
        Member member = repository.findByUserId(userId);

        JSONData<Member> data = new JSONData<>(member);
        data.setData(member);

        boolean isError = true;
        if(isError){
//            throw new RuntimeException("에러발생");
            throw new BadRequestException("에러발생");
        }

        return ResponseEntity.status(data.getStatus()).body(data);
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


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid RequestLogin form, Errors errors) {
        if(errors.hasErrors()){
            String message = errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));

            throw new RuntimeException(message);
        }

        log.info(form.toString());

        return ResponseEntity.ok().build();
    }




}
