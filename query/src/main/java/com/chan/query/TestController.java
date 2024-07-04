package com.chan.query;

import com.chan.query.entity.Member;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @PersistenceContext
    private final EntityManager em;

    public TestController(EntityManager em) {
        this.em = em;
    }

    @GetMapping("/test")
    public String type() {
        TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
        List<Member> resultList = query1.getResultList(); // Member 타입으로 반환

        Query query2 = em.createQuery("select m from Member m");
        List resultList1 = query2.getResultList(); // Object 타입으로 반환

        //이름 기준 파라미터 바인딩
        String usernameParam = "member1";
        TypedQuery<Member> query3 = em.createQuery("select m from Member m where m.username = :username", Member.class);
        query3.setParameter("username", usernameParam);
        List<Member> resultList2 = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", usernameParam)
                .getResultList();

        //위치 기준 파라미터 바인딩
        List<Member> resultList3 = em.createQuery("select m from Member m where m.username = ?1", Member.class)
                .setParameter(1, usernameParam)
                .getResultList();


        return "test";
    }
}
