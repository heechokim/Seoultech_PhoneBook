package com.example.phonebook;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /** 메인 뷰 관련 */
    private RecyclerView recyclerView;

    /** 리사이클러뷰 관련 */
    private RecyclerAdapter adapter;

    /** 프레그먼트 관련 */
    private FragmentManager fm;
    private FragmentTransaction tran;
    private Frg_President frg_president;
    private Frg_Engineer frg_engineer;


    /** onCreate 부분 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** 메인뷰 객체화 */
        recyclerView = findViewById(R.id.recyclerView);




        /** 왼쪽 리스트 뷰 관련 */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        /* 어댑터 선언 */
        adapter = new RecyclerAdapter();
        //adapter2 = new RecyclerAdapter2();

        /* 왼쪽 어댑터 클릭 리스너 선언 */
        adapter.setOnItemClickListener(this);

        /* 어댑터를 리사이클러뷰에 세팅 */
        recyclerView.setAdapter(adapter);


        /* 리스트에 문자열 세팅 함수 호출 */
        getDataLeft();      // 왼쪽 리스트 세팅

        if(findViewById(R.id.container) != null){
            if(savedInstanceState != null){
                return ;
            }
        }


      /** 프레그먼트 관련 세팅 */
      frg_president = new Frg_President();
      frg_engineer = new Frg_Engineer();

    }

    /** 왼쪽 리스트 뷰 아이템 클릭 리스너 */
    @Override
    public void onClick(View v) {
        int idx  = recyclerView.getChildAdapterPosition(v);


        if(idx == 0){
            /* 오른쪽 리스트 - 전체 */
            setFrag(0);
        }else if(idx == 1){
            /* 오른쪽 리스트 - 총장실 */
            setFrag(1);
          //  getDataPre();
        }else if(idx == 2){

           // getDataEng();
        }
    }

    /** getDataLeft() 함수 --> 리스트에 문자열 세팅 기능 */
    private void getDataLeft(){
        List<String> listNm_all = Arrays.asList("전체", "총장실", "공과대학", "미래융합대학", "메이커스칼리지", "정보통신대학" , "에너지바이오대학", "조형대학", "인문사회대학",
                "기술경영융합대학", "대학원", "행정부서", "교육지원/부속시설", "후생복지시설", "학생자치기구");

        for(int i = 0 ; i < listNm_all.size() ; i++){
            Data data = new Data();
            data.setName(listNm_all.get(i));
            adapter.addItem(data);
        }
        adapter.notifyDataSetChanged();

    }


//
//    private void getDataEng(){
//        List<String> listNm_all = Arrays.asList("제1행정실 - 행정지원팀", "제1행정실 - 교무학생팀", "제1행정실 - 실험실습지원팀",
//                "기계시스템디자인공학과 - 기계설계자동화", "기계시스템디자인공학과 - 기계디자인금형공학",
//                "기계자동차공학과 - 기계프로그램", "기계자동차공학과 - 자동차프로그램", "안전공학과",
//                "신소재공학과", "건설시스템공학과", "토목산업공학과", "건축학부 - 건축공학전공", "건축학부 - 건축학전공",
//                "건축산업학과", "기계설비공학과", "시설물유지관리공학과", "플랜트엔지니어링학과", "건축환경설비공학과", "철도아카데미");
//
//        for(int i = 0 ; i < listNm_all.size() ; i++){
//            Data data = new Data();
//            data.setName(listNm_all.get(i));
//            adapter2.addItem(data);
//        }
//        adapter2.notifyDataSetChanged();
//    }

    public void setFrag(int index){
        fm = getFragmentManager();
        tran = fm.beginTransaction();
        switch(index){
            case 0:
                tran.replace(R.id.container, frg_president);
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.container, frg_engineer);
                tran.commit();
                break;
        }
    }
}
