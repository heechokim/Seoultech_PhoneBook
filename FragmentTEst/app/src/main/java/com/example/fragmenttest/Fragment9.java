package com.example.fragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/** 인문사회대학 fragment 입니다. */
public class Fragment9 extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerviewLayoutmanager;
    private ArrayList<Data> data = new ArrayList<>();
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_right2, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_right2);
        recyclerView.setHasFixedSize(true);
        recyclerviewLayoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerviewLayoutmanager);
        myAdapter = new MyAdapter(data,getContext());
        recyclerView.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data.clear();
        data.add(new Data("제3행정실"));
        data.add(new Data("영어영문학과"));
        data.add(new Data("행정학과"));
        data.add(new Data("문예창작학과"));
        data.add(new Data("기초교육학부"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
