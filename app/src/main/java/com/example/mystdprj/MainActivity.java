package com.example.mystdprj;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity  {

    ViewPager viewPagerNotify;
    Fragment[] fragments;
    int mPositionNum;
    String mCategoryName;
    TextView tvMainTop;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        */

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("푸파의 최애 리스트");


        viewPagerNotify = findViewById(R.id.vp_notify);

        fragments = new Fragment[3];
        fragments[0] = new NotifyViewPagerFragment(1);
        fragments[1] = new NotifyViewPagerFragment(2);
        fragments[2] = new NotifyViewPagerFragment(3);

        NotifyViewPagerAdapter notifyViewPagerAdapter = new NotifyViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPagerNotify.setAdapter(notifyViewPagerAdapter);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new ListItem();
        Fragment notifyFragment = new NotifyFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fl_main, fragment)
                .add(R.id.fl_notify, notifyFragment)
                .commit();

        frameLayout = findViewById(R.id.fl_main_bottom);

        frameLayout.bringToFront();


    }

    private class NotifyViewPagerAdapter extends FragmentPagerAdapter {

        Fragment[] fragments;

        public NotifyViewPagerAdapter(FragmentManager fm, Fragment[] fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}
