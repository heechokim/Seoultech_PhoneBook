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

/** 행정부서 fragment 입니다. */
public class Fragment12 extends Fragment {
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
        myAdapter = new MyAdapter(data, getContext());
        recyclerView.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data.clear();
        data.add(new Data("교무처 - 교무팀"));
        data.add(new Data("교무처 - 학사지원팀"));
        data.add(new Data("학생처 - 학생지원팀"));
        data.add(new Data("학생처 - 장학복지팀"));
        data.add(new Data("학생처 - 보건진료소"));
        data.add(new Data("기획처 - 기획평가과 기획팀"));
        data.add(new Data("기획처 - 기획평가과 평가팀"));
        data.add(new Data("사무국 - 총무과 총무팀"));
        data.add(new Data("사무국 - 총무과 인사팀"));
        data.add(new Data("사무국 - 재무과 재무1팀"));
        data.add(new Data("사무국 - 재무과 재무2팀"));
        data.add(new Data("사무국 - 시설과 시설총괄팀"));
        data.add(new Data("사무국 - 시설과 시설관리팀"));
        data.add(new Data("사무국 - 시설과 전기지원팀"));
        data.add(new Data("사무국 - 시설과 기계지원팀"));
        data.add(new Data("사무국 - 시설과 토목조경팀"));
        data.add(new Data("사무국 - 예비군연대"));
        data.add(new Data("산학협력단 - 정책기획팀"));
        data.add(new Data("산학협력단 - 재무회계팀"));
        data.add(new Data("산학협력단 - 기술사업화팀"));
        data.add(new Data("산학협력단 - 미래전략기획단"));
        data.add(new Data("산학협력단 - 학술연구진흥팀"));
        data.add(new Data("산학협력단 - 연구관리1팀"));
        data.add(new Data("산학협력단 - 연구관리2팀"));
        data.add(new Data("산학협력단 - 감사팀"));
        data.add(new Data("입학관리본부 - 입학관리팀"));
        data.add(new Data("입학관리본부 - 입학전형팀"));
        data.add(new Data("홍보실"));


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
