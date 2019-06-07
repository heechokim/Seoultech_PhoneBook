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

/** 공과대학 fragment 입니다.*/
public class Fragment3 extends Fragment implements View.OnClickListener{

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
        myAdapter = new MyAdapter(data,getContext());
        myAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data.clear();
        data.add(new Data("제1행정실 - 행정지원팀","02-970-6172", "029706172"));
        data.add(new Data("제1행정실 - 교무학생팀","02-970-6183", "029706183"));
        data.add(new Data("제1행정실 - 실험실습지원팀","02-970-6178", "029706178"));
        data.add(new Data("기시디 - 기계설계자동화","02-970-6351", "029706351"));
        data.add(new Data("기시디 - 기계디자인금형공학","02-970-6306", "029706306"));
        data.add(new Data("기계자동차공학과 - 기계프로그램","02-970-6303", "029706303"));
        data.add(new Data("기계자동차공학과 - 자동차프로그램","02-970-6334", "029706334"));
        data.add(new Data("안전공학과","02-970-6372", "029706372"));
        data.add(new Data("신소재공학과","02-970-6637", "029706637"));
        data.add(new Data("건설시스템공학과","02-970-6501", "029706501"));
        data.add(new Data("토목산업공학과","번호 없음", "번호 없음"));
        data.add(new Data("건축학부 - 건축공학전공","02-970-6551", "029706551"));
        data.add(new Data("건축학부 - 건축학전공","02-970-6562", "029706562"));
        data.add(new Data("건축산업학과","02-970-6826", "029706826"));
        data.add(new Data("기계설비공학과","02-970-6828", "029706828"));
        data.add(new Data("시설물유지관리공학과","02-970-6565", "029706565"));
        data.add(new Data("플랜트엔지니어링학과","02-970-6828", "029706828"));
        data.add(new Data("건축환경설비공학과","02-970-6565", "029706565"));
        data.add(new Data("철도아카데미","02-970-6885", "029706885"));
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
