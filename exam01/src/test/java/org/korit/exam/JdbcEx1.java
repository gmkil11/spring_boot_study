package org.korit.exam;

import org.junit.jupiter.api.Test;
import org.korit.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.korit.entities.Member;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class JdbcEx1 {

    @Autowired
    private MemberRepository repository;
    // Autowired 를 사용해서 해야한다.

    @Test
    void test1() {
        List<Member> members = (List<Member>)repository.findAll();
        members.stream().forEach(System.out::println);
    }

    @Test
    void test2() {
        Member member = repository.findById(1L).orElse(null);
        System.out.println(member);

        member.setUserNm("(수정)사용자5");
        member.setModDt(LocalDateTime.now());
        repository.save(member);
    }

    @Test
    void test3() {
//        System.out.println(repository.getSequence());
        Member member = Member.builder()
                .userNo(repository.getSequence())
                .userId("user03")
                .userPw("12345678")
                .userNm("사용자03")
                .email("test1@test.org")
                .mobile("01000000000")
                .regDt(LocalDateTime.now())
                .build();

        repository.save(member);
    }

    @Test
    void test4() {
        repository.deleteById(22L);
    }

    @Test
    void test5() {
        Member member = repository.findByUserId("user01");
        System.out.println(member);
    }

    @Test
    void test6() {
        LocalDateTime edate = LocalDateTime.now();
        LocalDateTime sdate = edate.minusDays(7);

//        Pageable pageable = PageRequest.of(0,3);
        Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Order.desc("regDt"), Sort.Order.asc("userId")));

        List<Member> member = repository.findByRegDtBetween(sdate, edate, pageable);
        member.forEach(System.out::println);
    }

    @Test
    void test7() {
        List<Member> member = repository.findByUserNmContainingOrderByRegDtDesc("용");
        member.forEach(System.out::println);
    }


    @Test
    void test8() {
        List<Member> member = repository.getMembers("%용%");
        System.out.println(member);
    }
}
