package com.tung.model;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    @Size(min = 2, max = 30)
    private String userName;

    @Column(name = "address")
    private String address;

    @Size(min = 8, max = 12)
    @Column(name = "phonenumber")
    private String phoneNumber;

    public void User() {
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



}
