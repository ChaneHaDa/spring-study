package com.chan.query;

import com.chan.query.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CriteriaController {
    @PersistenceContext
    private final EntityManager em;

    public CriteriaController(EntityManager em) {
        this.em = em;
    }

    @GetMapping("/search")
    public String search() {
        //select m from Member m where m.username='회원1' order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);
        Predicate usernameEqual = cb.equal(m.get("username"), "m1");
        //숫자 타입 검색시
        Predicate ageGt = cb.greaterThan(m.<Integer>get("age"), 10);
        Order ageDesc = cb.desc(m.get("age"));

        cq.select(m)
                .where(usernameEqual)
                .orderBy(ageDesc);

        List<Member> resultList = em.createQuery(cq).getResultList();
        for(Member member : resultList) {
            System.out.println("member = " + member.getUsername());
        }

        return "search";
    }
}
