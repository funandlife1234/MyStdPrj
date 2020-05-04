package com.example.mystdprj.model;

import android.graphics.drawable.Drawable;

public class Category {
    int CategoryIdx;
    String CategoryName;
    int CategoryThumb;

    public Category(int categoryIdx, String categoryName, int cateThumb) {
        CategoryIdx = categoryIdx;
        CategoryName = categoryName;
        CategoryThumb = cateThumb;
    }

    public int getCategoryIdx() {
        return CategoryIdx;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public int getCategoryThumb() {
        return CategoryThumb;
    }
}
