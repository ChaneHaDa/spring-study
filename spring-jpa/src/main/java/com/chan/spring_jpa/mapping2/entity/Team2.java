package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

// 다대일 양방향
@Entity
public class Team2 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member2> members = new ArrayList<>();

    public Team2() {
    }

    public Team2(String name) {
        this.name = name;
    }

    public void addMember(Member2 member) {
        this.members.add(member);
        if(member.getTeam() != this){
            member.setTeam(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member2> getMembers() {
        return members;
    }

    public void setMembers(List<Member2> members) {
        this.members = members;
    }
}
