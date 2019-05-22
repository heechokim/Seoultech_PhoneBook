package com.example.phonebook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private View.OnClickListener onItemClick;

    /* adapter에 들어갈 list */
    private ArrayList<Data> listData = new ArrayList<>();
    private Context context;
    private Context ctx;

    void setOnItemClickListener(View.OnClickListener l){
        onItemClick = l;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /* item.xml inflate 시키기 */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        this.context = parent.getContext();
        /* ViewHolder가 return 됨 */
        view.setOnClickListener(onItemClick);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder holder, int position) {

        /* Item을 하나 하나 보여주는 함수 */
        holder.onBind(listData.get(position));

    }

    @Override
    public int getItemCount() {

        /* RecyclerView의 총 개수 */
        return listData.size();
    }

    void addItem(Data data){

        /* 외부에서 item을 추가시킬 함수 */
        listData.add(data);
    }


    /** RecyclerView의 핵심인 ViewHolder
     *  여기서 subView를 setting 해준다. */
    class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;


        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }


        void onBind(Data data){
            textView.setText(data.getName());
            //textView.setOnClickListener(this);
        }

        /*
        @Override
        public void onClick(View view) {

            // getAdapterPosition() 이 아이템 인덱스
            Toast.makeText(context, "왼쪽 리스트 눌렸습니다."+getAdapterPosition(), Toast.LENGTH_SHORT).show();



        }
        */

    }
}

