package com.example.mystdprj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotifyViewPagerFragment extends Fragment {

    int menuNum = 1;
    String menuUri;
    ImageView imageView;

    public NotifyViewPagerFragment(int val) {
        // Required empty public constructor
        menuNum = val;
        switch (val) {
            case 1:
                menuUri =
                "https://image-cdn.hypb.st/https%3A%2F%2Fkr.hypebeast.com%2Ffiles%2F2019%2F09%2Ftonkatsu-mania-pork-cutlet-seoul-restaurant-top-1.jpg?q=75&w=800&cbr=1&fit=max";;
                break;
            case 2:
                menuUri = "https://economychosun.com/query/upload/303/20190608214338_gubchoja.jpg";
                break;
            case 3:
                menuUri = "https://homecuisine.co.kr/files/attach/images/142/737/002/969e9f7dc60d42510c5c0353a58ba701.JPG";
                break;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View baseView = inflater.inflate(R.layout.fragment_notify_view_pager, container, false);

        imageView = baseView.findViewById(R.id.iv_notify);
        Glide.with(this).load(menuUri).centerCrop().into(imageView);

        return baseView;
    }
}
