package com.example.mystdprj;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystdprj.model.NotifyContent;

import java.util.ArrayList;

public class NotifyFragment extends Fragment {

    RecyclerView recyclerViewNotifyList;
    ArrayList<NotifyContent> notifyContents;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View baseView = inflater.inflate(R.layout.fragment_notify, container, false);
        View baseView = inflater.inflate(R.layout.fragment_notify, container, false);
        recyclerViewNotifyList =  baseView.findViewById(R.id.rv_notify_list);

        notifyContents = new ArrayList<>();
        notifyContents.add(new NotifyContent(1, "공지", "환영합니다.", "환영합니다요!"));
        notifyContents.add(new NotifyContent(1, "이벤트", "신규 이벤트 진행합니다.", "신규이벤트 진행합니다."));
        notifyContents.add(new NotifyContent(1, "공지", "어플의 이름을 공모합니다.", "무엇이 좋을까?"));
        notifyContents.add(new NotifyContent(1, "공지", "어플의 이름을 공모합니다.", "무엇이 좋을까?"));
        notifyContents.add(new NotifyContent(1, "공지", "어플의 이름을 공모합니다.", "무엇이 좋을까?"));

        NotifyListAdapter notifyListAdapter = new NotifyListAdapter(getActivity(), notifyContents);
        recyclerViewNotifyList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerViewNotifyList.setAdapter(notifyListAdapter);

        return baseView;
    }

    private class NotifyListAdapter extends RecyclerView.Adapter<NotifyRecyclerViewHolder> {

        Context mContext;
        ArrayList<NotifyContent> notifyContents;

        public NotifyListAdapter(Context context, ArrayList<NotifyContent> notifyContents) {
            mContext = context;
            this.notifyContents = notifyContents;
        }


        @NonNull
        @Override
        public NotifyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View baseView = LayoutInflater.from(getActivity()).inflate(R.layout.rv_list_item, parent, false);
            NotifyRecyclerViewHolder notifyRecyclerViewHolder = new NotifyRecyclerViewHolder(baseView);
            return notifyRecyclerViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull NotifyRecyclerViewHolder holder, int position) {
            NotifyContent item = notifyContents.get(position);
            holder.tvCategory.setText(item.getCategory());
            holder.tvSubject.setText(item.getSubject());
        }

        @Override
        public int getItemCount() {
            return notifyContents.size();
        }
    }

    private class NotifyRecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView tvCategory, tvSubject;

        public NotifyRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tv_list_category);
            tvSubject = itemView.findViewById(R.id.tv_list_subject);
        }
    }
}
