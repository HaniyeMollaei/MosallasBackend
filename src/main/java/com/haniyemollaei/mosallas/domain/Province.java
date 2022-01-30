package com.haniyemollaei.mosallas.domain;


import javax.persistence.*;

@Entity
@Table(name = "province")
public class Province {


    private int id;
    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

