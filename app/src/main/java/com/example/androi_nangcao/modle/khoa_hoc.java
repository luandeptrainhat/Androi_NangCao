package com.example.androi_nangcao.modle;

public class khoa_hoc {
    private  String name;
    private int hinh;

    public khoa_hoc(String name, int hinh) {
        this.name = name;
        this.hinh = hinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
