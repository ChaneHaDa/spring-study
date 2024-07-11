package com.chan.query;

import com.chan.query.DTO.UserDTO;
import com.chan.query.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/criteria")
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

    @GetMapping("/search2")
    public String search2() {
        //select new MemberDTO(m.username, m.age) from Member m
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserDTO> cq = cb.createQuery(UserDTO.class);
        Root<Member> m = cq.from(Member.class);
        cq.select(cb.construct(UserDTO.class, m.get("username"), m.get("age")));

        List<UserDTO> resultList = em.createQuery(cq).getResultList();
        for(UserDTO userDTO : resultList) {
            System.out.println("userDTO = " + userDTO.getUsername());
        }

        //tuple
        CriteriaQuery<Tuple> cq1 = cb.createTupleQuery();
        Root<Member> m1 = cq1.from(Member.class);
        cq1.multiselect(m1.get("username").alias("u1"), m1.get("age").alias("age"));
        List<Tuple> resultList1 = em.createQuery(cq1).getResultList();
        for(Tuple tuple : resultList1) {
            String username = tuple.get("u1", String.class);
            Integer age = tuple.get("age", Integer.class);
            System.out.println("username = " + username);
            System.out.println("age = " + age);
        }

        return "search2";
    }

    @GetMapping("/set")
    public String set() {
        //select m.team.name, max(m.age), min(m.age) from Member m group by m.team.name
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Member> m = cq.from(Member.class);

        Expression maxAge = cb.max(m.<Integer>get("age"));
        Expression minAge = cb.max(m.<Integer>get("age"));

        cq.multiselect(m.get("team").get("name"), maxAge, minAge);
        cq.groupBy(m.get("team").get("name"));
        cq.having(cb.gt(minAge, 10)); //having min(m.age) > 10

        List<Object[]> resultList = em.createQuery(cq).getResultList();

        for(Object[] row : resultList) {
            System.out.println("teamName = " + row[0]);
            System.out.println("maxAge = " + row[1]);
            System.out.println("minAge = " + row[2]);
        }

        return "set";
    }
}
