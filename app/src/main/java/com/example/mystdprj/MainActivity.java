package com.example.mystdprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mystdprj.model.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMainList;
    private ArrayList<Item> mItems = new ArrayList<>();
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItems.add(new Item("1인분"));
        mItems.add(new Item("한식"));
        mItems.add(new Item("분식"));
        mItems.add(new Item("치킨"));
        mItems.add(new Item("일식"));
        mItems.add(new Item("중식"));


        rvMainList = findViewById(R.id.rv_main_list);
        adapter = new MyRecyclerViewAdapter(this, mItems);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
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

    }

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder>{

        Context mContext;
        ArrayList<Item> mItems;

        public MyRecyclerViewAdapter(Context context, ArrayList<Item> items) {
            super();
            mContext = context;
            mItems = items;
        }

        @NonNull
        @Override
        public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.post_item, parent, false);
            return new MyRecyclerViewHolder(view, mContext, mItems);
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
            holder.tvPost.setText(mItems.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }

    private class MyRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvPost;
        Context mContext;
        ArrayList<Item> mItems;

        public MyRecyclerViewHolder(@NonNull View itemView, Context context, ArrayList<Item> items) {
            super(itemView);
            tvPost = itemView.findViewById(R.id.tv_item);
            tvPost.setOnClickListener(this);
            mContext = context;
            mItems = items;
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Toast.makeText(MainActivity.this, "Clicked"+position, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(mContext, PostItem.class);
            intent.putExtra("ITEM_POSITION", position);
            intent.putExtra("ITEM_CATEGORY", mItems.get(position).getName());
            startActivity(intent);
        }
    }

}
