package com.example.mystdprj.model;

import android.content.Context;

import java.util.ArrayList;

public class CategoryLab {
    private ArrayList<Category> categories;
    private static CategoryLab mCategoryLab = null;

    public CategoryLab(Context context){
        categories = new ArrayList<>();
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public synchronized CategoryLab getInstance(Context context){
        if(mCategoryLab == null){
            mCategoryLab = new CategoryLab(context);
        } else {
            return mCategoryLab;
        }

        return mCategoryLab;
    }

}
