package org.korit.repositories;

import org.korit.entities.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByUserId(String userId);



    List<Member> findByRegDtBetween(LocalDateTime sdate, LocalDateTime edate, Pageable pageable);

    List<Member> findByUserNmContainingOrderByRegDtDesc(String userNm);

    @Query("SELECT SEQ_MEMBER.nextval FROM DUAL") //
    long getSequence();

    @Query("SELECT * FROM MEMBER WHERE USER_NM LIKE :word ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("word") String keyword);
    // @Param 어노테이션에서 있는 값을 쿼리문에서 사용할 수 있다.
}