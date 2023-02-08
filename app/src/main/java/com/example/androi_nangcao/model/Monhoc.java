package com.example.androi_nangcao.model;

import java.io.Serializable;

public class Monhoc implements Serializable {
    private String code;
    private  String name;
    private  String teacher;
    private  int id; //them vo

    public Monhoc(String code, String name, String teacher, int id) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
