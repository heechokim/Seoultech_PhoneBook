package com.example.phonebook;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class Frg_President extends Fragment {

    /** 리사이클러뷰 관련 */
    private RecyclerView recyclerView;
    private RecyclerAdapter2 adapter2;
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        /** 리사이클러뷰 관련 */
        recyclerView = (RecyclerView)container.findViewById(R.id.rcy_president);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter2 = new RecyclerAdapter2();
        recyclerView.setAdapter(adapter2);
        getDataPre();

        return inflater.inflate(R.layout.president, container, false);
    }

    private void getDataPre(){
        List<String> listNm_all = Arrays.asList("총장실", "비서실장", "비서실");

        for(int i = 0 ; i < listNm_all.size() ; i++){
            Data data = new Data();
            data.setName(listNm_all.get(i));
            adapter2.addItem(data);
        }
        adapter2.notifyDataSetChanged();
    }
}
