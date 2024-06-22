package com.chan.spring_jpa;

import com.chan.spring_jpa.mapping1.constant.OrderStatus;
import com.chan.spring_jpa.mapping1.entity.Item;
import com.chan.spring_jpa.mapping1.entity.Member;
import com.chan.spring_jpa.mapping1.entity.Order;
import com.chan.spring_jpa.mapping1.entity.OrderItem;
import com.chan.spring_jpa.mapping1.repository.ItemRepository;
import com.chan.spring_jpa.mapping1.repository.MemberRepository;
import com.chan.spring_jpa.mapping1.repository.OrderItemRepository;
import com.chan.spring_jpa.mapping1.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Test
	void addData() {
		Item item = new Item("item1", 1000, 10);
		Member member = new Member("member1", "city1", "street1", "zipcode1");
		Order order = new Order(OrderStatus.ORDER);
		OrderItem orderItem = new OrderItem(1000, 10);

		Member savedMember = memberRepository.save(member);
		Item savedItem = itemRepository.save(item);

		order.setMember(savedMember);
		Order savedOrder = orderRepository.save(order);

		orderItem.setItem(savedItem);
		orderItem.setOrder(savedOrder);
		orderItemRepository.save(orderItem);
	}

}
