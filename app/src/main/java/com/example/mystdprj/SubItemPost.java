package com.example.mystdprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mystdprj.model.Company;

import java.util.ArrayList;

public class SubItemPost extends AppCompatActivity {

    ArrayList<Company> mCompanies;
    Company company = null;
    int categoryId = 0;
    TextView tvSubComName, tvSubCategory, tvSubPhoneNumber, tvSubAddress, tvSubMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_item_post);

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(categoryId != 0 && company != null) {

        } else {
            Intent intent = getIntent();
            mCompanies = (ArrayList<Company>) intent.getExtras().get("ITEM");
            int Position = (int) intent.getExtras().get("POSITION");
            company = getCompanyId(Position, mCompanies);
        }

        getSupportActionBar().setTitle(company.getName());

        tvSubComName = findViewById(R.id.tv_sub_com_name);
        tvSubAddress = findViewById(R.id.tv_sub_address);
        tvSubPhoneNumber = findViewById(R.id.tv_sub_phone);
        tvSubMenu = findViewById(R.id.tv_sub_menu);

        tvSubComName.setText(company.getName());
        tvSubAddress.setText(company.getAddress());
        tvSubPhoneNumber.setText(company.getPhone());
        tvSubMenu.setText(company.getMenu());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Company getCompanyId(int comId, ArrayList<Company> companies) {
        for (int i=0; i<companies.size(); i++){
            if(companies.get(i).getComId() == comId) {
                return companies.get(i);
            }
        }
        return null;
    }
}
