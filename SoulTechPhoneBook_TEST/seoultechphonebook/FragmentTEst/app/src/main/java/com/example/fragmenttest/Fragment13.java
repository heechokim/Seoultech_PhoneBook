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

/** 교육지원/부속시설 fragment 입니다. */
public class Fragment13 extends Fragment implements View.OnClickListener {
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
        data.add(new Data("도서관 - 학술정보지원팀","02-970-9031", "029709031"));
        data.add(new Data("도서관 - 학술정보서비스팀","02-970-9041", "029709041"));
        data.add(new Data("도서관 - 학술정보미디어팀","02-970-9039", "029709039"));
        data.add(new Data("정보전산원 - 정보화기획팀","02-970-9052", "029709052"));
        data.add(new Data("정보전산원 - 학사정보화팀","02-970-9057", "029709057"));
        data.add(new Data("정보전산원 - 일반정보화팀","02-970-9055", "029709055"));
        data.add(new Data("정보전산원 - 정보인프라팀","02-970-9064", "029709064"));
        data.add(new Data("생활관","02-970-9141", "029709141"));
        data.add(new Data("공동실험실습관 - 교육지원팀","02-970-7231", "029707231"));
        data.add(new Data("공동실험실습관 - 실습연구지원팀","02-970-7235", "029707235"));
        data.add(new Data("인재개발원 - 학생취업지원팀","02-970-9001", "029709001"));
        data.add(new Data("인재개발원 - 학생생활상담팀","02-970-9006", "029709006"));
        data.add(new Data("인재개발원 - 현장실습지원센터","02-970-6858", "029706858"));
        data.add(new Data("성평등상담센터 - 성평등상담팀","02-970-9008", "029709008"));
        data.add(new Data("기록관","02-970-9161", "029709161"));
        data.add(new Data("신문방송사 - 신문사","02-970-9174", "029709174"));
        data.add(new Data("신문방송사 - 방송국","02-970-9177", "029709177"));
        data.add(new Data("국제교육본부 - 국제교류팀","02-970-9221", "029709221"));
        data.add(new Data("국제교육본부 - 한국어교육팀","02-970-9219", "029709219"));
        data.add(new Data("국제교육본수 - 어학교육팀","02-970-7203", "029707203"));
        data.add(new Data("대학교육혁신원 - 교육정책연구센터","02-970-9312", "029709312"));
        data.add(new Data("대학교육혁신원 - 교수학습개발센터","02-970-9251", "029709251"));
        data.add(new Data("대학교육혁신원 - 공학교육혁신센터","02-970-9235", "029709235"));
        data.add(new Data("대학교육혁신원 - 교양교육연구센터","02-970-9312", "029709312"));
        data.add(new Data("창업지원단 - 창업보육센터","02-970-9022", "029709022"));
        data.add(new Data("창업지원단 - 창업교육센터","02-970-9151", "029709151"));
        data.add(new Data("산학협력선도대학사업단","02-970-9121", "029709121"));
        data.add(new Data("장애학생지원센터","02-970-6054", "029706054"));
        data.add(new Data("미술관","02-970-6215", "029706215"));
        data.add(new Data("성평등상담센터","02-970-9006", "029709006"));
        data.add(new Data("학생군사교육단(ROTC)","02-970-9274", "029709274"));
        data.add(new Data("(재)서울과학기술대학교 발전기금","02-970-9263", "029709263"));
        data.add(new Data("노원과학영재교육원","02-970-9281", "029709281"));
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
