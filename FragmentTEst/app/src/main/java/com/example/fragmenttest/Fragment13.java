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

/** 교육지원/부속시설 fragment 입니다. */
public class Fragment13 extends Fragment {
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
        data.add(new Data("도서관 - 학술정보지원팀"));
        data.add(new Data("도서관 - 학술정보서비스팀"));
        data.add(new Data("도서관 - 학술정보미디어팀"));
        data.add(new Data("정보전산원 - 정보화기획팀"));
        data.add(new Data("정보전산원 - 학사정보화팀"));
        data.add(new Data("정보전산원 - 일반정보화팀"));
        data.add(new Data("정보전산원 - 정보인프라팀"));
        data.add(new Data("생활관"));
        data.add(new Data("공동실험실습관 - 교육지원팀"));
        data.add(new Data("공동실험실습관 - 실습연구지원팀"));
        data.add(new Data("인재개발원 - 학생취업지원팀"));
        data.add(new Data("인재개발원 - 학생생활상담팀"));
        data.add(new Data("인재개발원 - 현장실습지원센터"));
        data.add(new Data("성평등상담센터 - 성평등상담팀"));
        data.add(new Data("기록관"));
        data.add(new Data("신문방송사 - 신문사"));
        data.add(new Data("신문방송사 - 방송국"));
        data.add(new Data("국제교육본부 - 한국어교육팀"));
        data.add(new Data("국제교육본수 - 어학교육팀"));
        data.add(new Data("대학교육혁신원 - 교육정책연구센터"));
        data.add(new Data("대학교육혁신원 - 교수학습개발센터"));
        data.add(new Data("대학교육혁신원 - 공학교육혁신센터"));
        data.add(new Data("대학교육혁신원 - 교양교육연구센터"));
        data.add(new Data("창업지원단 - 창업보육센터"));
        data.add(new Data("창업지원단 - 창업교육센터"));
        data.add(new Data("산학협력선도대학사업단"));
        data.add(new Data("장애학생지원센터"));
        data.add(new Data("미술관"));
        data.add(new Data("성평등상담센터"));
        data.add(new Data("학생군사교육단(ROTC)"));
        data.add(new Data("(재)서울과학기술대학교 발전기금"));
        data.add(new Data("노원과학영재교육원"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
