package com.example.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getData();
    }

    private void init(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData(){

        List<String> listName = Arrays.asList("전체", "총장실", "비서실장", "비서실", "공과대학", "미래융합대학", "메이커스칼리지", "정보통신대학" , "에너지바이오대학", "조형대학", "인문사회대학",
                "기술경영융합대학", "대학원", "행정부서", "교육지원/부속시설", "후생복지시설", "학생자치기구");

        for(int i = 0 ; i < listName.size() ; i++){
            Data data = new Data();
            data.setName(listName.get(i));

            adapter.addItem(data);
        }

        adapter.notifyDataSetChanged();
    }
}
