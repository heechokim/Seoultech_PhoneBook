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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    private ArrayList<Data> FilteredData;
    private ArrayList<Data> Mydata;
    private View.OnClickListener onItemClick;
    private Dialog dialog;
    private Context context;

    public MyAdapter(ArrayList<Data> mydata, Context context) {
        Mydata = mydata;
        this.context = context;
    }
    void setOnItemClickListener(View.OnClickListener l){ onItemClick = l;}

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

    @Override
    public Filter getFilter() {
        return new Filter()
        {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence)
            {
                FilterResults results = new FilterResults();

                //If there's nothing to filter on, return the original data for your list
                if(charSequence == null || charSequence.length() == 0)
                {
                    results.values = Mydata;
                    results.count = Mydata.size();
                }
                else
                {
                    ArrayList<Data> filterResultsData = new ArrayList<Data>();

                    for(Data data : Mydata)
                    {
                        //In this loop, you'll filter through originalData and compare each item to charSequence.
                        //If you find a match, add it to your new ArrayList
                        //I'm not sure how you're going to do comparison, so you'll need to fill out this conditional
                        if(Mydata.toString().toUpperCase().contains(Mydata.toString().toUpperCase()))
                        {
                            filterResultsData.add(data);
                        }
                    }

                    results.values = filterResultsData;
                    results.count = filterResultsData.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults)
            {
                FilteredData = (ArrayList<Data>)filterResults.values;
                notifyDataSetChanged();

                if (filterResults.count>0){
                    notifyDataSetChanged();
                } else{

                }
            }
        };
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
