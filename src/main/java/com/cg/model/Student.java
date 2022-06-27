package com.cg.model;

import java.util.Date;

public class Student {
    private int id;
    private String fullname;
    private String birth;
    private String address;
    private String phone;
    private String email;
    private int classId;

    public Student() {
    }

    public Student(int id, String fullname, String birth, String address, String phone, String email, int classId) {
        this.id = id;
        this.fullname = fullname;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classId = classId;
    }

    public Student(String fullname, String birth, String address, String phone, String email, int classId) {
        this.fullname = fullname;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classId = classId;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

}
