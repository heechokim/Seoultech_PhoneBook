package com.example.fragmenttest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    private ArrayList<Data> items;
    private ArrayList<Data> Mydata;
    private View.OnClickListener onItemClick;
    private Dialog dialog;
    private Context context;
    Filter mfilter;

    public MyAdapter(ArrayList<Data> mydata, Context context) {
        Mydata = mydata;
        this.context = context;
        items=mydata;
    }

    void setOnItemClickListener(View.OnClickListener l){ onItemClick = l;}
  /**  @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                items.clear();
                if (charString.isEmpty()) {
                    items = Mydata;
                } else {
                    List<Data> filteredList = new ArrayList<>();
                    for (Data row : Mydata) {

                        if (row.getString().toLowerCase().contains(charString.toLowerCase()) || row.getPhonenum().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    items = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = items;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                items = (ArrayList<Data>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }*/
     public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        items.clear();
        if(charText.length()==0){
            items.addAll(Mydata);
        } else{
            for(Data data : Mydata){
                String name = data.getString();
                if(name.toLowerCase().contains(charText)){
                    items.add(data);
                }
            }
        }
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        view.setOnClickListener(onItemClick);

        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return Mydata.size();
    }


    /** 내가 만든 MyViewHolder 클래스 */
    public  class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textview_item);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewholder, int position) {
        viewholder.textView.setText(Mydata.get(position).getString());
    }

}
/** 어댑터 클래스 만들기
 * 1. RecyclerView.Adapter<MyAdapter.MyViewHolder> 을 상속받는다.
 * 이 때, MyViewHolder 은 사용자 정의 클래스라 빨간줄이 날 것이다.
 * 2. 필요한 함수들을 오버라이딩한다. (onCreateViewHolder, onBindViewHolder, getItemCount 함수)
 * 3. MyViewHolder 클래스를 만든다. 이 클래스 안에서 리스트뷰에 넣을 객체들을 선언하고 초기화 시켜준다.
 * 4. onCreateViewHolder 함수를 작성한다.
 * (리사이클러뷰를 담고 있는 fragment xml 파일을 인플레이트 시켜주고, 사용자 클래스인 MyViewHolder을 생성하고 호출시킨다.)
 * 5. ArrayList<Data> 를 선언한다.
 * 6. 이 클래스의 생성자를 생성한다. (매개변수로는 ArrayList와 Activity 를 받는다.)
 * 7. onBindViewHolder 함수를 작성한다. --> 이 함수에서 데이터와 아이템xml 의 뷰들을 연결시켜줘야 한다.
 * 8. getItemCount() 함수를 작성한다. ArrayList의 사이즈를 리턴하게 한다.
 * */
