package com.ponto.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionID = 1L;

    @Id
    @SequenceGenerator(name = "seq_users", sequenceName = "seq_users", allocationSize = 1)
    @GeneratedValue(generator = "seq_users", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "daily_in_come")
    private Double dailyInCome;

    public String test(){
        return "Hello test";
    }
}
