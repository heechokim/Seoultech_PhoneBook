package com.example.fragmenttest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerviewLayoutmanager;
    private ArrayList<Data> data = new ArrayList<>();
    private MyAdapter myAdapter;
    FragmentManager fm;
    FragmentTransaction tran;
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
        setTitle("전화번호부");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_left);
        recyclerView.setHasFixedSize(true);
        recyclerviewLayoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerviewLayoutmanager);
        myAdapter = new MyAdapter(data, getApplicationContext());
        myAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(myAdapter);
        leftList();
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
        setFragment(0);

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
/** 메인 엑티비티 자바 파일 작성하기
 * 1. activity.xml 의 버튼 3개를 선언한다.
 * 2. 프래그먼트 매니저를 선언한다.
 * 3. 프래그먼트 Transaction 을 선언한다.
 * 4. 각 프래그먼트 플래스를 선언한다.
 * 5. 각 버튼을 객체화 시킨다.
 * 6. onClickListener 을 implement 하고, onClick 함수를 오버라이딩 한다.
 * 7. 각 버튼에 클릭 리스너를 set 시킨다.
 * 8. onCreate 함수 안에 switch 문을 작성한다. v 는 이 리스너가 적용된 각 버튼이다.
 * 9. 선언만했던 프래그먼트 클래스를 초기화 시켜준다.
 * 10. setFragment 라는 사용자 함수를 만든다. 이 함수 안에서 프래그먼트 매니저와
 * transaction 을 초기화 해준다.(transaction은 프래그먼트를 교체할 때 마다 새로 초기화 해줘야 한다.)
 * 또 이 함수안에서 프래임레이아웃에 프레그 먼트를 바꿔주는 코드를 작성해준다.
 * 11. 아까 작성했던 버튼의 onClick 함수에 setFragment() 함수를 호출시켜준다. */
