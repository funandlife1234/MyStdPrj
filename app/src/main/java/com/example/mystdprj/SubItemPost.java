package com.example.mystdprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mystdprj.model.Company;

import java.util.ArrayList;

public class SubItemPost extends AppCompatActivity {

    ArrayList<Company> mCompanies;
    TextView tvSubComName, tvSubCategory, tvSubPhoneNumber, tvSubAddress, tvSubMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_item_post);

        /*
        Intent intent = getIntent();
        mCompanies = (ArrayList<Company>) intent.getExtras().get("ITEM");
        int Position = (int) intent.getExtras().get("POSITION");
        Company company = mCompanies.get(Position);

        tvSubComName = findViewById(R.id.tv_sub_com_name);
        tvSubAddress = findViewById(R.id.tv_sub_address);
        tvSubPhoneNumber = findViewById(R.id.tv_sub_phone);
        tvSubMenu = findViewById(R.id.tv_sub_menu);

        tvSubComName.setText(company.getName());
        tvSubAddress.setText(company.getAddress());
        tvSubPhoneNumber.setText(company.getPhone());
        tvSubMenu.setText(company.getMenu());

         */

    }
}
