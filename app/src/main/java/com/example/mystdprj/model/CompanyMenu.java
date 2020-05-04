package com.example.mystdprj.model;

import java.io.Serializable;

public class CompanyMenu implements Serializable {
    int Price;
    String Name;
    String MenuInfo;

    public CompanyMenu(int price, String name, String menuInfo) {
        Price = price;
        Name = name;
        MenuInfo = menuInfo;
    }

    public int getPrice() {
        return Price;
    }

    public String getName() {
        return Name;
    }

    public String getMenuInfo() {
        return MenuInfo;
    }
}
