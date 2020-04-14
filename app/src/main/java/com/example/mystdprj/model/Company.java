package com.example.mystdprj.model;

import java.io.Serializable;

public class Company implements Serializable {
    int comId;
    String name;
    String category;
    String phone;
    String address;
    String menu;

    public Company(int comId, String name, String category, String phone, String address, String menu) {
        this.comId = comId;
        this.name = name;
        this.category = category;
        this.phone = phone;
        this.address = address;
        this.menu = menu;
    }

    public int getComId() {
        return comId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getMenu() {
        return menu;
    }
}
