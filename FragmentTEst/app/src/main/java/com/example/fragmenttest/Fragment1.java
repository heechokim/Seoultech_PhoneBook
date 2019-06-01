package com.example.fragmenttest;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment1 extends Fragment implements View.OnClickListener {

    View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerviewLayoutmanager;
    private ArrayList<Data> data = new ArrayList<>();
    private MyAdapter myAdapter;
    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_right2, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_right2);
        recyclerView.setHasFixedSize(true); // 리사이클러뷰를 고정시켜준다. 왜 고정시키는줄은 모르겠음 ㅋㅋ
        recyclerviewLayoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerviewLayoutmanager);
        myAdapter = new MyAdapter(data,getContext());
        myAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(myAdapter);


        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_call);
        TextView dialog_textview = (TextView)dialog.findViewById(R.id.dialog_text);
        Button dialog_btn1 = (Button)dialog.findViewById(R.id.dialog_btn1);
        Button dialog_btn2 = (Button)dialog.findViewById(R.id.dialog_btn2);
        dialog_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "통화", Toast.LENGTH_SHORT).show();
            }
        });
        dialog_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "복사", Toast.LENGTH_SHORT).show();
            }
        });
        /** 이거 번호, data 에 번호 쓰는 란 만들어서 받아와야 할듯!*/
        dialog_textview.setText("010-2352-0300");

        return view;
    }

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data.clear();
        data.add(new Data("테"));
        data.add(new Data("스"));
        data.add(new Data("트"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        int idx = recyclerView.getChildAdapterPosition(v);
        dialog.show();

    }
}


/** 프래그 먼트 자바 클래스 만들기
 * 1. Fragment 를 상속받는다.
 * 2. onCreateView 함수를 오버라이딩 받는다.
 * 3. View 변수를 선언하고 onCreateView 함수 안에서 view 변수에 fragment.xml 을 인플레이트 시킨다.
 * 4. fragment.xml 에 있는 리사이클러뷰를 선언하고 onCreateView 함수 안에서 초기화 시킨다.
 * 5. RecyclerView.LayoutManger 을 선언해주고, onCreateView 안에서 초기화 해준다.
 * 6. recyclerview에 레이아웃매니저를 set 해준다.
 * 7. ArrayList<Data>를 선언한다. --> 어댑터의 생성자로 쓰인다.
 * 8. 어댑터를 선언해준다.
 * 9. onCreateView 함수 안에서 어댑터를 초기화 하고, 리사이클러뷰에 set 해준다.
 * 10. onCreate 함수를 오버라이딩 시킨다.
 * 11. onCreate 함수 안에서 ArrayList를 초기화 시키고 실제 data를 넣어준다. */