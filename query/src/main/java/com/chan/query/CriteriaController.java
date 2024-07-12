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

    @GetMapping("/order")
    public String order() {
        //select m from Member m order by m.age desc, m.username desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);

        cq.orderBy(cb.desc(m.get("age")), cb.desc(m.get("username")));

        List<Member> resultList = em.createQuery(cq).getResultList();
        for(Member member : resultList) {
            System.out.println("member = " + member);
        }

        return "order";
    }

    @GetMapping("/join")
    public String join() {
        //select m from Member m join m.team t
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);
        Join<Member, Member> t = m.join("team", JoinType.INNER);
        //m.join("team") -> 내부조인
        //m.join("team", JoinType.INNER) -> 내부조인
        //m.join("team", JoinType.LEFT) -> 외부조인
        //m.fetch("team", JoinType.LEFT) -> 패치조인
        cq.select(m);

        List<Member> resultList = em.createQuery(cq).getResultList();
        for(Member member : resultList) {
            System.out.println("member = " + member);
        }

        return "join";
    }

    @GetMapping("/sub")
    public String subQuery() {
        //select m from Member m where m.age = (select max(m2.age) from Member m2)
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);

        Subquery<Integer> subQuery = cq.subquery(Integer.class);
        Root<Member> m2 = subQuery.from(Member.class);
        subQuery.select(cb.max(m2.get("age")));

        cq.select(m)
                .where(cb.equal(m.get("age"), subQuery));

        List<Member> resultList = em.createQuery(cq).getResultList();
        for(Member member : resultList) {
            System.out.println("member = " + member);
        }

        return "sub";
    }

    @GetMapping("/case")
    public String caseQuery() {
        //select case when m.age <= 10 then '학생요금' " +
        // "when m.age >= 60 then '경로요금' " +
        // "else '일반요금' end " +
        // "from Member m
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object> cq = cb.createQuery(Object.class);
        Root<Member> m = cq.from(Member.class);

        cq.select(
                cb.selectCase()
                        .when(cb.le(m.get("age"), 10), "학생요금")
                        .when(cb.ge(m.get("age"), 60), "경로요금")
                        .otherwise("일반요금")
        );

        List<Object> resultList = em.createQuery(cq).getResultList();
        for(Object s : resultList) {
            System.out.println("s = " + s);
        }

        return "case";
    }

    @GetMapping("/parameter")
    public String parameter() {
        //String usernameParam = "m1";
        //int ageParam = 10;
        //select m from Member m where m.username = :username and m.age > :age
        String usernameParam = "m1";
        int ageParam = 10;

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);

        cq.select(m)
                .where(cb.and(
                        cb.equal(m.get("username"), cb.parameter(String.class, "username")),
                        cb.gt(m.get("age"), cb.parameter(Integer.class, "age"))
                ));

        List<Member> resultList = em.createQuery(cq)
                .setParameter("username", usernameParam)
                .setParameter("age", ageParam)
                .getResultList();

        for(Member member : resultList) {
            System.out.println("member = " + member);
        }

        return "parameter";
    }


}
