package com.example.mystdprj;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystdprj.model.Category;
import com.example.mystdprj.model.CategoryLab;
import com.example.mystdprj.model.Company;

import java.util.ArrayList;

public class PostItemFragment extends Fragment {

    TextView mTextView;
    RecyclerView mRecyclerView, recyclerViewCategory;
    RecyclerViewCategoryAdapter mAdapter;
    ArrayList<Company> mCompanies;
    ArrayList<Category> mCategories;
    int mPosition, comId;
    String mCategory;
    CategoryLab mCategoryLab;
    Fragment[] arrFragments;
    Company company;

    public PostItemFragment(ArrayList<Company> company) {

        mCompanies = company;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.activity_company_list_inner, container, false);

        mRecyclerView = baseView.findViewById(R.id.rv_company_list);
        mAdapter = new RecyclerViewCategoryAdapter(getActivity(), mCompanies);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);

        return baseView;
    }

    public class RecyclerViewCategoryAdapter extends RecyclerView.Adapter<RecyclerViewCategoryHolder> {

        Context mContext;
        ArrayList<Company> mCompanies;

        public RecyclerViewCategoryAdapter(Context context, ArrayList<Company> companies) {
            mContext = context;
            mCompanies = companies;
        }

        @NonNull
        @Override
        public RecyclerViewCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_post_item, parent, false);
            return new RecyclerViewCategoryHolder(view, mContext, mCompanies);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewCategoryHolder holder, int position) {
            Company Item = mCompanies.get(position);
            holder.tvComName.setText(Item.getName());
            holder.tvPhoneNumber.setText(Item.getPhone());
            holder.tvAddress.setText(Item.getAddress());
            holder.tvMenu.setText(Item.getBestMenuName());
            holder.tvBedalTip.setText(String.valueOf(Item.getBedalTip()));
            holder.tvBedalTime.setText(Item.getArrivalTime());
        }

        @Override
        public int getItemCount() {
            return mCompanies.size();
        }
    }

    public class RecyclerViewCategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvComName, tvPhoneNumber, tvAddress, tvMenu, tvBedalTime, tvBedalTip;
        LinearLayout llOuterItem;
        Context mContext;
        ArrayList<Company> mCompanies;

        public RecyclerViewCategoryHolder(@NonNull View itemView, Context context, ArrayList<Company> companies) {
            super(itemView);
            llOuterItem = itemView.findViewById(R.id.ll_outer_item);
            mCompanies = companies;
            mContext = context;

            tvComName = itemView.findViewById(R.id.tv_com_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvPhoneNumber = itemView.findViewById(R.id.tv_phone);
            tvMenu = itemView.findViewById(R.id.tv_menu);
            tvBedalTime = itemView.findViewById(R.id.tv_bedal_time);
            tvBedalTip = itemView.findViewById(R.id.tv_bedal_tip);
            llOuterItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent mintent = new Intent(mContext, SubItemPost.class);
            //Toast.makeText(mContext, "Test", Toast.LENGTH_SHORT).show();
            int position = getAdapterPosition();
            int comPosition = mCompanies.get(position).getComId();
            mintent.putExtra("ITEM", mCompanies);
            mintent.putExtra("POSITION", comPosition);
            Toast.makeText(mContext, "Test "+mCompanies.get(position).getComId(), Toast.LENGTH_SHORT).show();
            startActivity(mintent);
        }
    }
}
