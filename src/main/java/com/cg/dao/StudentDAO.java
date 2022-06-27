package com.cg.dao;

import java.util.Date;

public class StudentDAO {
    private int id;
    private String fullname;
    private Date birth;
    private String address;
    private String phone;
    private String email;
    private String name;

    public StudentDAO() {
    }

    public StudentDAO(int id, String fullname, Date birth, String address, String phone, String email, String name) {
        this.id = id;
        this.fullname = fullname;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentDAO{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
