package com.example.fragmenttest;

import android.Manifest;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/** 학생자치기구 fragment 입니다. */
public class Fragment14 extends Fragment implements View.OnClickListener{
    View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerviewLayoutmanager;
    private ArrayList<Data> data = new ArrayList<>();
    private MyAdapter myAdapter;
    private Intent intent;
    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_right2, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_right2);
        recyclerView.setHasFixedSize(true);
        recyclerviewLayoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerviewLayoutmanager);
        myAdapter = new MyAdapter(data, getContext());
        myAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data.clear();
        data.add(new Data("총학생회실","02-970-7011", "029707011"));
        data.add(new Data("총졸업준비위원회","02-970-7019", "029707019"));
        data.add(new Data("교지편집실","02-970-7020", "029707020"));
        data.add(new Data("동아리연합회","02-970-7022", "029707022"));
        data.add(new Data("학생복지위원회","02-970-7023", "029707023"));
        data.add(new Data("공과대학","02-970-7044", "029707044"));
        data.add(new Data("정보통신대학/에너지바이오대학","02-970-7050", "029707050"));
        data.add(new Data("조형대학","02-970-7055", "029707055"));
        data.add(new Data("인문사회대학","02-970-7061", "029707061"));
        data.add(new Data("기술경영융합대학","02-970-7015", "029707015"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        int idx = recyclerView.getChildAdapterPosition(v);
        Dialog(idx);
        dialog.show();

    }

    /** 전화번호 복사 */
    public void Copy(Context context, String string){
        ClipboardManager clipboardManager = (ClipboardManager)context.getSystemService(context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("phoneNumber", string);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getContext(), "복사되었습니다", Toast.LENGTH_SHORT).show();
    }

    public void Dialog(final int idx){
        final String phoneNum = data.get(idx).getCall();
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_call);
        TextView dialog_textview = (TextView)dialog.findViewById(R.id.dialog_text);
        dialog_textview.setText(data.get(idx).getPhonenum());
        Button dialog_btn1 = (Button)dialog.findViewById(R.id.dialog_btn1);
        Button dialog_btn2 = (Button)dialog.findViewById(R.id.dialog_btn2);
        dialog_textview.setText(data.get(idx).getPhonenum());
        dialog_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** 통화 권한 확인 후, 통화 */
                int permissionCheck = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE);
                if(permissionCheck == PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 0);
                }else{
                    intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+phoneNum));
                    getContext().startActivity(intent);
                }

            }
        });
        dialog_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Copy(getContext(), phoneNum);
            }
        });
    }
}
