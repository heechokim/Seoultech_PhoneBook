package com.kimchohee.fragmenttest;

import android.Manifest;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/** 조형대학 fragment 입니다. */
public class Fragment8 extends Fragment implements View.OnClickListener {
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
        data.add(new Data("제3행정실","02-970-6201", "029706201"));
        data.add(new Data("디자인학과","02-970-6667", "029706667"));
        data.add(new Data("도예학과","02-970-6618", "029706618"));
        data.add(new Data("금속공예디자인학과","02-970-6664", "029706664"));
        data.add(new Data("조형예술학과","02-970-6635", "029706636"));
        data.add(new Data("시각문화융합디자인학과","02-970-6674", "029706674"));
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
