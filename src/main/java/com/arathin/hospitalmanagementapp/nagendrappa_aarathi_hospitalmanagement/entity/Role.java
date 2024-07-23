package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "roles")
public class Role {


    //primary key and auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    //Relationship that many users can have many role like parent and admin
    @ManyToMany(mappedBy = "roles")
    private List<User> users;


}
