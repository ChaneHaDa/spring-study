package com.chan.spring_data_jpa;

import com.chan.spring_data_jpa.repository.ChildRepository;
import com.chan.spring_data_jpa.repository.ParentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    public MainController(ParentRepository parentRepository, ChildRepository childRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
    }

    @GetMapping("/parents")
    public String getParents() {
        return parentRepository.findAll().toString();
    }

    @GetMapping("/parents/{name}")
    public String getParentByName(@PathVariable("name") String name) {
        return parentRepository.findByName(name).toString();
    }
}
