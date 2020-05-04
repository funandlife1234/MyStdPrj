package com.example.mystdprj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mystdprj.model.Category;
import com.example.mystdprj.model.CategoryLab;
import com.example.mystdprj.model.Company;
import com.example.mystdprj.model.CompanyMenu;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PostItem extends AppCompatActivity {

    TextView mTextView;
    RecyclerView mRecyclerView, recyclerViewCategory;
    ArrayList<Company> mCompanies;
    ArrayList<Category> mCategories;
    int mPosition;
    String mCategory;
    CategoryLab mCategoryLab;
    Fragment[] arrFragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String category = "";

        Intent intent = getIntent();
        mPosition = (int) intent.getExtras().get("ITEM_POSITION");
        mCategory = (String) intent.getExtras().get("ITEM_CATEGORY");

        int position = mPosition;
        category = mCategory;

        getSupportActionBar().setTitle(category);
        mCategoryLab = new CategoryLab(this);
        mCategories = mCategoryLab.getInstance(this).getCategories();
        Log.d("Categories", mCategories.get(0).getCategoryName());

        mCompanies = new ArrayList<>();

        // 1. 서버에서 아이템 목록을 가져와서 add 시키는 스레드를 만드는 작업 필요. 서버에서 카테고리에 맞게 필터링 한 결과를 가지고 여기서 추가한다.
        // 2. 메뉴 클래스를 만들었고 그것에 맞게 레이아웃을 변경해서 보여주도록 해야 할 것.

        // 회사idx, 회사이름, 카테고리, 전화번호, 주소, 메뉴객체, 별점, 최소주문금액, 대표메뉴이름, 배달소요시간, 배달팁, 영업상태, 가게소개
        mCompanies.add(new Company(1, "김밥천국", category, "010-0000-0000", "서울시 강남구 도곡동 423번지",
                new CompanyMenu(2000, "야채김밥", "신선한 야채로 만든 김밥"), 5, 5000, "야채김밥", "50~55",
                3000, true, "그냥 김밥천국"));
        mCompanies.add(new Company(2, "토마토김밥", category, "010-0000-0000", "서울시 강남구 도곡동 4212번지",
                new CompanyMenu(2500, "소고기김밥", "신선한 소고기로 만든 김밥"), 5, 5000, "토마토김밥", "30~35",
                3000, true, "토마토 김밥이 맛있냐"));
        mCompanies.add(new Company(3, "명륜진사갈비", category, "010-0000-0000", "서울시 강남구 도곡동 423번지",
                new CompanyMenu(3000, "치즈김밥", "신선한 치즈로 만든 김밥"), 5, 5000, "돼지갈비", "25~30",
                3000, true, "무한으로 즐겨요 명륜진사갈비"));
        mCompanies.add(new Company(4, "BBQ치킨", category, "010-0000-0000", "서울시 강남구 도곡동 423번지",
                new CompanyMenu(3500, "불닭김밥", "신선한 불닭으로 만든 김밥"), 5, 5000, "간장치킨", "60~70",
                3000, true, "전지현지BHC는 아니구나"));
        mCompanies.add(new Company(5, "존맛탱 통닭", category, "010-0000-0000", "서울시 강남구 도곡동 423번지",
                new CompanyMenu(4000, "돈까스김밥", "신선한 돈까스로 만든 김밥"), 5, 5000, "존맛 통닭스", "50~53",
                3000, true, "존 빠삭빠삭 매콤달콤 혀에 촤르르 녹는 그 맛입니다요"));
        mCompanies.add(new Company(6, "자금성중국요리", category, "010-0000-0000", "서울시 강남구 도곡동 423번지",
                new CompanyMenu(4500, "오리김밥", "신선한 오리로 만든 김밥"), 5, 5000, "탕수육", "30~39",
                3000, true, "탕수육 존맛탱입니다. 3끼 탕수육만 쌉가능"));

        arrFragments = new Fragment[mCategories.size()];
        for (int i = 0; i < mCategories.size(); i++) {
            arrFragments[i] = new PostItemFragment(mCompanies);
        }

        TabLayout tabLayout = findViewById(R.id.tl_cate);

        ViewPager viewPager = findViewById(R.id.vp_cate);
        TopViewPagerAdapter topViewPagerAdapter = new TopViewPagerAdapter(getSupportFragmentManager(), arrFragments, mCategories);
        viewPager.setAdapter(topViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                setActionBarTitle(mCategories.get(pos).getCategoryName());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void setActionBarTitle(String cate){
        getSupportActionBar().setTitle(cate);
    }

    public class TopViewPagerAdapter extends FragmentPagerAdapter {

        Fragment[] arrFragments;
        ArrayList<Category> categories;
        String category;

        public TopViewPagerAdapter(FragmentManager fm, Fragment[] arrFragments, ArrayList<Category> mCategories) {
            super(fm);
            this.arrFragments = arrFragments;
            categories = mCategories;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            category = categories.get(position).getCategoryName();
            return category;
        }



        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return categories.size();
        }
    }
}

