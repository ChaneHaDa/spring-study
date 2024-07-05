package com.chan.query;

import com.chan.query.DTO.UserDTO;
import com.chan.query.entity.Member;
import com.chan.query.entity.Team;
import com.chan.query.value.Address;
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

    @GetMapping("/type-param")
    public String typeParam() {
        TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
        List<Member> resultList = query1.getResultList(); // Member 타입으로 반환

        Query query2 = em.createQuery("select m from Member m");
        List resultList1 = query2.getResultList(); // Object 타입으로 반환

        //이름 기준 파라미터 바인딩
        String usernameParam = "m1";
        TypedQuery<Member> query3 = em.createQuery("select m from Member m where m.username = :username", Member.class);
        query3.setParameter("username", usernameParam);
        List<Member> resultList2 = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", usernameParam)
                .getResultList();

        //위치 기준 파라미터 바인딩
        List<Member> resultList3 = em.createQuery("select m from Member m where m.username = ?1", Member.class)
                .setParameter(1, usernameParam)
                .getResultList();

        System.out.println(resultList.size());
        System.out.println(resultList1.size());
        System.out.println(resultList2.size());
        System.out.println(resultList3.size());

        return "type-param";
    }

    @GetMapping("/projection")
    public String projection() {
        //엔티티 프로젝션
        TypedQuery<Team> query1 = em.createQuery("select m.team from Member m", Team.class);
        List<Team> resultList1 = query1.getResultList();
        System.out.println(resultList1.get(0).getName());

        //임베디드 타입 프로젝션
        TypedQuery<Address> query2 = em.createQuery("select o.address from Orders o", Address.class);
        List<Address> resultList2 = query2.getResultList();
        System.out.println(resultList2.get(0).getCity());

        //여러 값 조회
        Query query3 = em.createQuery("SELECT m.username, m.age FROM Member m");
        List<Object[]> resultList3 = query3.getResultList();
        for(Object[] row : resultList3){
            String username = (String) row[0];
            Integer age = (Integer) row[1];
            System.out.println("username = " + username);
            System.out.println("age = " + age);
        }

        //DTO로 조회
        TypedQuery<UserDTO> query4 = em.createQuery("select new com.chan.query.DTO.UserDTO(m.username, m.age) from Member m", UserDTO.class);
        List<UserDTO> resultList4 = query4.getResultList();
        System.out.println(resultList4.get(0).getUsername());

        return "projection";
    }
}
