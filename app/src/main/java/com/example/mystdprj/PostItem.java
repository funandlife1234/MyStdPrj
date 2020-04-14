package com.example.mystdprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mystdprj.model.Company;

import java.util.ArrayList;

public class PostItem extends AppCompatActivity {

    TextView mTextView;
    RecyclerView mRecyclerView;
    RecyclerViewCategoryAdapter mAdapter;
    ArrayList<Company> mCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        mTextView = findViewById(R.id.tv_category);
        String category = "";

        Intent intent = getIntent();
        if (intent != null) {
            int position = (int) intent.getExtras().get("ITEM_POSITION");
            category = (String) intent.getExtras().get("ITEM_CATEGORY");
            mTextView.setText(category);
        }

        mCompanies = new ArrayList<>();

        // 1. 서버에서 아이템 목록을 가져와서 add 시키는 스레드를 만드는 작업 필요.

        mCompanies.add(new Company(1,"김밥천국", category, "010-0000-0000", "서울시 강남구 도곡동 423번지", "야채김밥"));
        mCompanies.add(new Company(2,"김밥천국", category, "010-0000-0000", "서울시 강남구 도곡동 4212번지", "야채김밥"));
        mCompanies.add(new Company(3,"김밥천국", category, "010-0000-0000", "서울시 강남구 도곡동 423번지", "야채김밥"));
        mCompanies.add(new Company(4,"김밥천국", category, "010-0000-0000", "서울시 강남구 도곡동 423번지", "야채김밥"));
        mCompanies.add(new Company(5,"김밥천국", category, "010-0000-0000", "서울시 강남구 도곡동 423번지", "야채김밥"));
        mCompanies.add(new Company(6,"김밥천국", category, "010-0000-0000", "서울시 강남구 도곡동 423번지", "야채김밥"));

        mRecyclerView = findViewById(R.id.rv_company_list);
        mAdapter = new RecyclerViewCategoryAdapter(PostItem.this, mCompanies);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);

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
            holder.tvMenu.setText(Item.getMenu());
        }

        @Override
        public int getItemCount() {
            return mCompanies.size();
        }
    }

    public class RecyclerViewCategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvComName, tvCategory, tvPhoneNumber, tvAddress, tvMenu;
        LinearLayout llOuterItem;
        Context mContext;
        ArrayList<Company> mCompanies;

        public RecyclerViewCategoryHolder(@NonNull View itemView, Context context, ArrayList<Company> companies) {
            super(itemView);
            llOuterItem = itemView.findViewById(R.id.ll_outer_item);
            mCompanies = companies;
            mContext = context;

            tvComName = itemView.findViewById(R.id.tv_com_name);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvPhoneNumber = itemView.findViewById(R.id.tv_phone);
            tvMenu = itemView.findViewById(R.id.tv_menu);
            llOuterItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent mintent = new Intent(PostItem.this, SubItemPost.class);
            //Toast.makeText(mContext, "Test", Toast.LENGTH_SHORT).show();
            int position = getAdapterPosition();
            int comPosition = mCompanies.get(position).getComId();
            mintent.putExtra("ITEM", mCompanies);
            mintent.putExtra("POSITION", comPosition);
            Toast.makeText(PostItem.this, "Test "+mCompanies.get(position).getComId(), Toast.LENGTH_SHORT).show();
            startActivity(mintent);
        }
    }
}
