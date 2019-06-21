package com.example.fragmenttest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;


public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder> {
    private Context mCtx;
    private View.OnClickListener onItemClick;
    private ArrayList<Data> items= null;
    private ArrayList<Data> arrayList;

    public FilterAdapter(ArrayList<Data> mydata, Context context) {
        this.mCtx=context;
        this.items = new ArrayList<Data>();
        this.items = mydata;
        arrayList = new ArrayList<Data>();
        arrayList.addAll(items);
    }
    void setOnItemClickListener(View.OnClickListener l){ onItemClick = l;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);

        v.setOnClickListener(onItemClick);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Data item=items.get(position);

        holder.tv_address.setText(item.getString());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        items.clear();
        if (charText.length() == 0) {
            items.addAll(arrayList);
        } else {
            for (Data data : arrayList) {
                String name = data.getString();
                if (name.toLowerCase().contains(charText)) {
                    items.add(data);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_address;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_address= (TextView) itemView.findViewById(R.id.textview_item);
        }
    }
}
