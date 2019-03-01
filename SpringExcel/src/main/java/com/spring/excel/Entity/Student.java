package com.spring.excel.Entity;

public class Student {
    private byte[] uid;

    private String name;

    private Integer age;

    private Integer classid;

    private Integer seclassid;

    public byte[] getUid() {
        return uid;
    }

    public void setUid(byte[] uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getSeclassid() {
        return seclassid;
    }

    public void setSeclassid(Integer seclassid) {
        this.seclassid = seclassid;
    }
}