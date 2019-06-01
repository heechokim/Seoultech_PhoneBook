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

/** 공과대학 fragment 입니다.*/
public class Fragment3 extends Fragment {

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
        data.add(new Data("제1행정실 - 행정지원팀"));
        data.add(new Data("제1행정실 - 교무학생팀"));
        data.add(new Data("제1행정실 - 실험실습지원팀"));
        data.add(new Data("기시디 - 기계설계자동화"));
        data.add(new Data("기시디 - 기계디자인금형공학"));
        data.add(new Data("기계자동차공학과 - 기계프로그램"));
        data.add(new Data("기계자동차공학과 - 자동차프로그램"));
        data.add(new Data("안전공학과"));
        data.add(new Data("신소재공학과"));
        data.add(new Data("건설시스템공학과"));
        data.add(new Data("토목산업공학과"));
        data.add(new Data("건축학부 - 건축공학전공"));
        data.add(new Data("건축학부 - 건축학전공"));
        data.add(new Data("건축산업학과"));
        data.add(new Data("기계설비공학과"));
        data.add(new Data("시설물유지관리공학과"));
        data.add(new Data("플랜트엔지니어링학과"));
        data.add(new Data("건축환경설비공학과"));
        data.add(new Data("철도아카데미"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
