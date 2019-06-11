package com.ph.listviewsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder> {
    private Context mCtx;

    private List<Data> items= null;
    private ArrayList<Data> arrayList;

    public FilterAdapter(ArrayList<Data> mydata, Context context) {
        this.mCtx=context;
        this.items=mydata;
        arrayList = new ArrayList<Data>();
        arrayList.addAll(mydata);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Data item=items.get(position);

        holder.tv_address.setText(item.getAddress());
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
        ImageView iv_icon;
        TextView tv_address;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_address= (TextView) itemView.findViewById(R.id.tvAddress);
            iv_icon = (ImageView) itemView.findViewById(R.id.ivIcon);

        }


    }
}
