package com.example.phonebook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerAdapter adapter;
    private RecyclerAdapter2 adapter2;
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    Context ctx;

    @Override
    public void onClick(View v) {
        int idx  = recyclerView.getChildAdapterPosition(v);

        List<String> listNm_president = Arrays.asList("총장실", "비서실장", "비서실");
        List<String> listNm_Engineer = Arrays.asList("제1행정실 - 행정지원팀", "제1행정실 - 교무학생팀", "제1행정실 - 실험실습지원팀");

        if(idx == 1){
            /* 오른쪽 리스트 - 총장실 */
            for(int i = 0 ; i < listNm_president.size() ; i++){
                Data data = new Data();
                data.setName(listNm_president.get(i));
                adapter2.addItem(data);
                recyclerView2.setAdapter(adapter2);
            }
        }else if(idx == 2){
            /* 오른쪽 리스트 - 공과대학 */
            //TODO:처음에 나왔던 리스트 지우고 갱신시키는 코드 찾아서 여기에 넣어야함
            for(int i = 0 ; i < listNm_Engineer.size() ; i++){
                Data data = new Data();
                data.setName(listNm_Engineer.get(i));
                adapter2.addItem(data);
                recyclerView2.setAdapter(adapter2);
            }
        }

        //adapter2 = new RecyclerAdapter2();
        // callFragment(RoomInformFragment())
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getData();
    }

    private void init(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerView2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        adapter = new RecyclerAdapter();

        adapter.setOnItemClickListener(this);

        adapter2 = new RecyclerAdapter2();
        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter2);
    }

    private void getData(){

        List<String> listNm_all = Arrays.asList("전체", "총장실", "공과대학", "미래융합대학", "메이커스칼리지", "정보통신대학" , "에너지바이오대학", "조형대학", "인문사회대학",
                "기술경영융합대학", "대학원", "행정부서", "교육지원/부속시설", "후생복지시설", "학생자치기구");


        /* 왼쪽 리스트 전체 */
        for(int i = 0 ; i < listNm_all.size() ; i++){
            Data data = new Data();
            data.setName(listNm_all.get(i));

            adapter.addItem(data);
        }

        adapter.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
    }
}
