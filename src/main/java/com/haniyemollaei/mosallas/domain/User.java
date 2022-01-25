package com.haniyemollaei.mosallas.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String mobileNo;
    private String userType;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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
}
