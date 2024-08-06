package com.chan.spring_data_jpa;

import com.chan.spring_data_jpa.entity.Child;
import com.chan.spring_data_jpa.entity.Parent;
import com.chan.spring_data_jpa.repository.ChildRepository;
import com.chan.spring_data_jpa.repository.ParentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired private ParentRepository parentRepository;
	@Autowired private ChildRepository childRepository;


	@Test
	void contextLoads() {


		Parent parent = new Parent();
		parent.setName("Parent 1");

		Child child1 = new Child();
		child1.setName("Child 1");
		child1.setParent(parent);

		Child child2 = new Child();
		child2.setName("Child 2");
		child2.setParent(parent);

		List<Child> children = new ArrayList<>();
		children.add(child1);
		children.add(child2);
		parent.setChilds(children);

		parentRepository.save(parent);

	}

}
