package com.example.mystdprj.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable {
    int comId;
    String name;
    String category;
    String phone;
    String address;
    String menu;
    int rating; // 평점 별 갯수
    int minOrderPrice; // 최소 주문 금액
    String bestMenuName; // 대표 메뉴 이름 및 간단 소개
    String arrivalTime; // 배달 소요시간
    int bedalTip; // 배달 팁
    boolean State; // 영업중 or 영업종료
    String soge; // 가게 소개
    ArrayList<CompanyMenu> companyMenus;

    // 회사idx, 회사이름, 카테고리, 전화번호, 주소, 메뉴객체, 별점, 최소주문금액, 대표메뉴이름, 배달소요시간, 배달팁, 영업상태, 가게소개
    public Company(int comId, String name, String category, String phone, String address, CompanyMenu companyMenu, int rating, int minOrderPrice, String bestMenuName, String arrivalTime,
                   int bedalTip, boolean state, String soge) {
        this.comId = comId;
        this.name = name;
        this.category = category;
        this.phone = phone;
        this.address = address;
        this.rating = rating;
        this.minOrderPrice = minOrderPrice;
        this.bestMenuName = bestMenuName;
        this.arrivalTime = arrivalTime;
        this.bedalTip = bedalTip;
        this.State = state;
        this.soge = soge;

        companyMenus = new ArrayList<>();
        addMenu(companyMenu);
    }

    public void addMenu(CompanyMenu companyMenu) {
        companyMenus.add(companyMenu);
    }

    public CompanyMenu getCompanyMenu(int position){
        return companyMenus.get(position);
    }

    public ArrayList<CompanyMenu> getCompanyMenus() {
        return companyMenus;
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

    public int getRating() {
        return rating;
    }

    public int getMinOrderPrice() {
        return minOrderPrice;
    }

    public String getBestMenuName() {
        return bestMenuName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getBedalTip() {
        return bedalTip;
    }

    public boolean isState() {
        return State;
    }

    public String getSoge() {
        return soge;
    }
}

