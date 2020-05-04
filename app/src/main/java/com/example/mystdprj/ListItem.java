package com.example.mystdprj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mystdprj.model.Category;
import com.example.mystdprj.model.CategoryLab;
import com.example.mystdprj.model.Item;

import java.util.ArrayList;

public class ListItem extends Fragment {

    private RecyclerView rvMainList;
    private ArrayList<Item> mItems = new ArrayList<>();
    private MyRecyclerViewAdapter adapter;
    private ArrayList<Category> mCategories;
    private CategoryLab categoryLab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.activity_list_item, container, false);
        String[] cate = {"한식", "분식", "치킨", "족발,보쌈", "중식", "양식", "도시락", "프랜차이즈", "찜,탕", "야식"};
        String[] cateThumb = {"han", "bun", "chicken", "gogi", "jja", "yang",
                "dosirak", "fastfood", "jeon", "ya"};

        mCategories = new ArrayList<>();
        for(int i = 0; i < cate.length; i++) {
            mCategories.add(i, new Category(i, cate[i], getResources().getIdentifier(cateThumb[i], "drawable", "com.example.mystdprj") ));
            Log.d("mCategories" , mCategories.get(i).getCategoryName());
            mItems.add(new Item(cate[i]));
        }
        categoryLab = new CategoryLab(getActivity());
        categoryLab.getInstance(getActivity()).setCategories(mCategories);

        rvMainList = baseView.findViewById(R.id.rv_main_list);
        adapter = new MyRecyclerViewAdapter(getActivity(), mCategories);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        /**
         gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){

        @Override
        public int getSpanSize(int position) {
        return 0;
        }
        });
         */
        rvMainList.setLayoutManager(gridLayoutManager);
        rvMainList.setAdapter(adapter);

        return baseView;
    }

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder>{

        Context mContext;
        ArrayList<Category> mCategory;

        public MyRecyclerViewAdapter(Context context, ArrayList<Category> items) {
            super();
            mContext = context;
            mCategory = items;
        }

        @NonNull
        @Override
        public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.post_item, parent, false);
            return new MyRecyclerViewHolder(view, mContext, mCategory);
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
            holder.tvPost.setText(mCategory.get(position).getCategoryName());
            Glide.with(holder.itemView.getContext()).load(mCategory.get(position).getCategoryThumb()).into(holder.ivCate);
            //holder.ivCate.setImageResource(mCategory.get(position).getCategoryThumb());
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }

    private class MyRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvPost;
        ImageView ivCate;
        Context mContext;
        ArrayList<Category> mItems;

        public MyRecyclerViewHolder(@NonNull View itemView, Context context, ArrayList<Category> items) {
            super(itemView);
            tvPost = itemView.findViewById(R.id.tv_item);
            tvPost.setOnClickListener(this);
            ivCate = itemView.findViewById(R.id.iv_cate_thumb);
            ivCate.setOnClickListener(this);
            mContext = context;
            mItems = items;
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Toast.makeText(getActivity(), "Clicked"+position, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), PostItem.class);
            intent.putExtra("ITEM_POSITION", position);
            intent.putExtra("ITEM_CATEGORY", mItems.get(position).getCategoryName());
            startActivity(intent);
        }
    }
}
