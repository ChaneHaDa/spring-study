package com.chan.query;

import com.chan.query.entity.Member;
import com.chan.query.entity.Orders;
import com.chan.query.entity.Product;
import com.chan.query.entity.Team;
import com.chan.query.repository.MemberRepository;
import com.chan.query.repository.OrdersRepository;
import com.chan.query.repository.ProductRepository;
import com.chan.query.repository.TeamRepository;
import com.chan.query.value.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QueryApplicationTests {
	@Autowired private MemberRepository memberRepository;
	@Autowired private OrdersRepository ordersRepository;
	@Autowired private ProductRepository productRepository;
	@Autowired private TeamRepository teamRepository;

	@Test
	void contextLoads() {
		Team team1 = new Team("t1");
		Team team2 = new Team("t2");
		team1 = teamRepository.save(team1);
		team2 = teamRepository.save(team2);

		Product product1 = new Product("p1", 1000, 1000);
		Product product2 = new Product("p2", 2000, 2000);
		product1 = productRepository.save(product1);
		product2 = productRepository.save(product2);

		Member member1 = new Member("m1", 10);
		member1.setTeam(team1);
		Member member2 = new Member("m2", 20);
		member2.setTeam(team2);
		member1 = memberRepository.save(member1);
		member2 = memberRepository.save(member2);

		Orders orders1 = new Orders(1000, new Address("s1", "c1", "d1"));
		orders1.setMember(member1);
		orders1.setProduct(product1);
		Orders orders2 = new Orders(2000, new Address("s2", "c2", "d2"));
		orders2.setMember(member2);
		orders2.setProduct(product2);
		orders1 = ordersRepository.save(orders1);
		orders2 = ordersRepository.save(orders2);

	}

}
