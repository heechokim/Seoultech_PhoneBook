package com.kimchohee.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.ArrayList;
// 검색을 위해 두 개 더 임포트 때림
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerviewLayoutmanager;
    private ArrayList<Data> data = new ArrayList<>();
    private MyAdapter myAdapter;

    // 검색을 위한 것들 조져보자
    private ArrayList<Data> dataList = new ArrayList<>();

    private FilterAdapter filterAdapter ;
    RecyclerView filterView;
    EditText editsearch;
    LinearLayoutManager mLayoutManager;

    FragmentManager fm;
    FragmentTransaction tran;
    Fragment0 fragment0;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment5 fragment5;
    Fragment6 fragment6;
    Fragment7 fragment7;
    Fragment8 fragment8;
    Fragment9 fragment9;
    Fragment10 fragment10;
    Fragment11 fragment11;
    Fragment12 fragment12;
    Fragment13 fragment13;
    Fragment14 fragment14;
    Fragment15 fragment15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("서울과학기술대학교 전화번호부");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_left);
        recyclerView.setHasFixedSize(true);
        recyclerviewLayoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerviewLayoutmanager);
        myAdapter = new MyAdapter(data, getApplicationContext());
        myAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(myAdapter);

        // 검색을 위해 조진 것
        dataList.clear();

        leftList();
        fragment0 = new Fragment0();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();
        fragment6 = new Fragment6();
        fragment7 = new Fragment7();
        fragment8 = new Fragment8();
        fragment9 = new Fragment9();
        fragment10 = new Fragment10();
        fragment11 = new Fragment11();
        fragment12 = new Fragment12();
        fragment13 = new Fragment13();
        fragment14 = new Fragment14();
        fragment15 = new Fragment15();
        setFragment(-1);
        setFragment(0);

        // 검색 조지기
        editsearch =(EditText)findViewById(R.id.et_search);

        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editsearch.getText().toString()
                        .toLowerCase(Locale.getDefault());
                if(text.length() != 0) {
                    fragment0.myAdapter.filter(text);
                    setFragment(-1);
                }
                else{
                    setFragment(0);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        int idx = recyclerView.getChildAdapterPosition(v);
        switch (idx) {
            case 0:
                setFragment(0);
                break;
            case 1:
                setFragment(1);
                break;
            case 2:
                setFragment(2);
                break;
            case 3:
                setFragment(3);
                break;
            case 4:
                setFragment(4);
                break;
            case 5:
                setFragment(5);
                break;
            case 6:
                setFragment(6);
                break;
            case 7:
                setFragment(7);
                break;
            case 8:
                setFragment(8);
                break;
            case 9:
                setFragment(9);
                break;
            case 10:
                setFragment(10);
                break;
            case 11:
                setFragment(11);
                break;
            case 12:
                setFragment(12);
                break;
            case 13:
                setFragment(13);
                break;
            case 14:
                setFragment(14);
                break;
        }
    }


    public void setFragment(int n){
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();
        switch(n){
            case -1:
                tran.replace(R.id.framelayout_right, fragment0);
                tran.commit();
                break;

            case 0:
                tran.replace(R.id.framelayout_right, fragment1);
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.framelayout_right, fragment2);
                tran.commit();
                break;
            case 2:
                tran.replace(R.id.framelayout_right, fragment3);
                tran.commit();
                break;
            case 3:
                tran.replace(R.id.framelayout_right, fragment4);
                tran.commit();
                break;
            case 4:
                tran.replace(R.id.framelayout_right, fragment5);
                tran.commit();
                break;
            case 5:
                tran.replace(R.id.framelayout_right, fragment6);
                tran.commit();
                break;
            case 6:
                tran.replace(R.id.framelayout_right, fragment7);
                tran.commit();
                break;
            case 7:
                tran.replace(R.id.framelayout_right, fragment8);
                tran.commit();
                break;
            case 8:
                tran.replace(R.id.framelayout_right, fragment9);
                tran.commit();
                break;
            case 9:
                tran.replace(R.id.framelayout_right, fragment10);
                tran.commit();
                break;
            case 10:
                tran.replace(R.id.framelayout_right, fragment11);
                tran.commit();
                break;
            case 11:
                tran.replace(R.id.framelayout_right, fragment12);
                tran.commit();
                break;
            case 12:
                tran.replace(R.id.framelayout_right, fragment13);
                tran.commit();
                break;
            case 13:
                tran.replace(R.id.framelayout_right, fragment14);
                tran.commit();
                break;
            case 14:
                tran.replace(R.id.framelayout_right, fragment15);
                tran.commit();
                break;

        }
    }

    public void leftList(){
        data.clear();

        data.add(new Data("전체", "번호 없음", "번호 없음"));
        data.add(new Data("총장실", "번호 없음", "번호 없음"));
        data.add(new Data("공과대학", "번호 없음", "번호 없음"));
        data.add(new Data("미래융합대학", "번호 없음", "번호 없음"));
        data.add(new Data("메이커스칼리지", "번호 없음", "번호 없음"));
        data.add(new Data("정보통신대학", "번호 없음", "번호 없음"));
        data.add(new Data("에너지바이오대학", "번호 없음", "번호 없음"));
        data.add(new Data("조형대학", "번호 없음", "번호 없음"));
        data.add(new Data("인문사회대학", "번호 없음", "번호 없음"));
        data.add(new Data("기술경영융합대학", "번호 없음", "번호 없음"));
        data.add(new Data("대학원", "번호 없음", "번호 없음"));
        data.add(new Data("행정부서", "번호 없음", "번호 없음"));
        data.add(new Data("교육지원/부속시설", "번호 없음", "번호 없음"));
        data.add(new Data("학생자치기구", "번호 없음", "번호 없음"));
        data.add(new Data("후생복지시설", "번호 없음", "번호 없음"));
    }
}