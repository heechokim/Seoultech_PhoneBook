package com.example.phonebook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ItemViewHolder> {

    private ArrayList<Data> listData2 = new ArrayList<>();
    private Context context2;

    @NonNull
    @Override
    public RecyclerAdapter2.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        this.context2 = parent.getContext();
        return new RecyclerAdapter2.ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter2.ItemViewHolder holder, int position) {
        holder.onBind(listData2.get(position));
    }

    @Override
    public int getItemCount() {
        return listData2.size();
    }

    void addItem(Data data){
        listData2.add(data);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView textView2;

        public ItemViewHolder(View itemView) {
            super(itemView);

            textView2 = itemView.findViewById(R.id.textView2);
        }

        void onBind(Data data){
            textView2.setText(data.getName());
            textView2.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /* getAdapterPosition() 이 아이템 인덱스 */
            Toast.makeText(context2, "오른쪽 리스트 눌렸습니다."+getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}
