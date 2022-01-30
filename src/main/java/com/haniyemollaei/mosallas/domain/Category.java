package com.haniyemollaei.mosallas.domain;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    private int id;
    private String categoryName;


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
    @Column(name = "CATEGORY_NAME")
    public String getCategory_name() {
        return categoryName;
    }

    public void setCategory_name(String categoryName) {
        this.categoryName = categoryName;
    }


}
