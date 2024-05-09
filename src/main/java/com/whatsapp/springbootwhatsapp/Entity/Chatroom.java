package com.whatsapp.springbootwhatsapp.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Chatroom {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "chatroom_users",
            joinColumns = {@JoinColumn(
                    name = "chatroom_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "user_id"
            )}
    )
    private List<UserProfile> users = new ArrayList();

    public Chatroom() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserProfile> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserProfile> users) {
        this.users = users;
    }
}

