package com.example.fragmenttest;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.EditText;
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
        data.add(new Data("총장실"));
        data.add(new Data("비서실장"));
        data.add(new Data("비서실"));
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
        data.add(new Data("제1행정실"));
        data.add(new Data("융합기계공학과"));
        data.add(new Data("건설환경융합공학과"));
        data.add(new Data("헬스케어학과"));
        data.add(new Data("문화예술학과"));
        data.add(new Data("영미문화학과"));
        data.add(new Data("벤처경영학과"));
        data.add(new Data("제2행정실"));
        data.add(new Data("전기정보공학과"));
        data.add(new Data("전자IT미디어공학과"));
        data.add(new Data("컴퓨터공학과"));
        data.add(new Data("제2행정실"));
        data.add(new Data("화공생명공학과"));
        data.add(new Data("환경공학과"));
        data.add(new Data("식품공학과"));
        data.add(new Data("정밀화학과"));
        data.add(new Data("스포츠과학과"));
        data.add(new Data("안경광학과"));
        data.add(new Data("제3행정실"));
        data.add(new Data("디자인학과"));
        data.add(new Data("도예학과"));
        data.add(new Data("금속공예디자인학과"));
        data.add(new Data("조형예술학과"));
        data.add(new Data("시각문화융합디자인학과"));
        data.add(new Data("제3행정실"));
        data.add(new Data("영어영문학과"));
        data.add(new Data("행정학과"));
        data.add(new Data("문예창작학과"));
        data.add(new Data("기초교육학부"));
        data.add(new Data("제3행정실"));
        data.add(new Data("산업정보시스템전공"));
        data.add(new Data("MSDE 전공"));
        data.add(new Data("ITM 전공"));
        data.add(new Data("경영학과 - 경영학전공"));
        data.add(new Data("경영학과 - GTM 전공"));
        data.add(new Data("제4행정실 - 일반행정팀"));
        data.add(new Data("제4행정실 - 학사지원팀"));
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
        data.add(new Data("총학생회실"));
        data.add(new Data("총졸업준비위원회"));
        data.add(new Data("교지편집실"));
        data.add(new Data("동아리연합회"));
        data.add(new Data("학생복지위원회"));
        data.add(new Data("공과대학"));
        data.add(new Data("정보통신대학/에너지바이오대학"));
        data.add(new Data("조형대학"));
        data.add(new Data("인문사회대학"));
        data.add(new Data("기술경영융합대학"));

        Intent intent = new Intent(getActivity(),MainActivity.class);
        intent.putExtra("Data",data);
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