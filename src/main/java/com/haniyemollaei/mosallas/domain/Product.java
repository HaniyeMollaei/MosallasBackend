package com.haniyemollaei.mosallas.domain;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {


    private int id;
    private String name;
    private String shopId;
    private String price;
    private int inventory;
    private boolean hasOnlineSell;
    private String description;
    private int categoryId;
    private double star;
    private byte[] image;


    //default id refers to user id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "shop_id")
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "inventory")
    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "has_online_sell")
    public boolean getHasOnlineSell() {
        return hasOnlineSell;
    }

    public void setHasOnlineSell(boolean hasOnlineSell) {
        this.hasOnlineSell = hasOnlineSell;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "star")
    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    @Basic
    @Column(length = 1000000, name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
