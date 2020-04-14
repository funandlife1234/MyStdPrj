package com.example.mystdprj.model;

public class Company {
    String name;
    String category;
    String phone;
    String address;
    String menu;

    public Company(String name, String category, String phone, String address, String menu) {
        this.name = name;
        this.category = category;
        this.phone = phone;
        this.address = address;
        this.menu = menu;
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
