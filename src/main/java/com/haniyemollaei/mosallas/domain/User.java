package com.haniyemollaei.mosallas.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String mobileNo;
    private String userType;
    private String password;
    private String name;
    private Long provinceId;
    private Long cityId;
    private String address;
    private String postalCode;
    private Long walletBalance;



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "PROVINCE_ID")
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }


    @Basic
    @Column(name = "CITY_ID")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }


    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Basic
    @Column(name = "POSTAL_CODE")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "WALLET_BALANCE")
    public Long getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Long walletBalance) {
        this.walletBalance = walletBalance;
    }



    @Column(name = "MOBILE_NO")
    @Basic
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Column(name = "USER_TYPE")
    @Basic
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Column(name = "PASSWORD")
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Column(name = "NAME")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
