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
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/** 행정부서 fragment 입니다. */
public class Fragment12 extends Fragment implements View.OnClickListener{
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
        data.add(new Data("교무처 - 교무팀","02-970-6024", "029706024"));
        data.add(new Data("교무처 - 학사지원팀","02-970-2034", "029702034"));
        data.add(new Data("학생처 - 학생지원팀","02-970-6044", "029706044"));
        data.add(new Data("학생처 - 장학복지팀","02-970-6052", "029706052"));
        data.add(new Data("학생처 - 보건진료소","02-970-7199", "029707199"));
        data.add(new Data("기획처 - 기획평가과 기획팀","02-970-6064", "029706064"));
        data.add(new Data("기획처 - 기획평가과 평가팀","02-970-6072", "029706072"));
        data.add(new Data("사무국 - 총무과 총무팀","02-970-6092", "029706092"));
        data.add(new Data("사무국 - 총무과 인사팀","02-970-6112", "029706112"));
        data.add(new Data("사무국 - 재무과 재무1팀","02-970-6122", "029706122"));
        data.add(new Data("사무국 - 재무과 재무2팀","02-970-6128", "029706128"));
        data.add(new Data("사무국 - 시설과 시설총괄팀","02-970-6142", "029706142"));
        data.add(new Data("사무국 - 시설과 시설관리팀","02-970-6145", "029706145"));
        data.add(new Data("사무국 - 시설과 전기지원팀","02-970-6148", "029706148"));
        data.add(new Data("사무국 - 시설과 기계지원팀","02-970-6152", "029706152"));
        data.add(new Data("사무국 - 시설과 토목조경팀","02-970-6154", "029706154"));
        data.add(new Data("사무국 - 예비군연대","02-970-6082", "029706082"));
        data.add(new Data("산학협력단 - 정책기획팀","02-970-9082", "029709082"));
        data.add(new Data("산학협력단 - 재무회계팀","02-970-9121", "029709121"));
        data.add(new Data("산학협력단 - 기술사업화팀","02-970-9156", "029709156"));
        data.add(new Data("산학협력단 - 미래전략기획단","02-970-9247", "029709247"));
        data.add(new Data("산학협력단 - 학술연구진흥팀","02-970-9138", "029709138"));
        data.add(new Data("산학협력단 - 연구관리1팀","02-970-9126", "029709126"));
        data.add(new Data("산학협력단 - 연구관리2팀","02-970-9101", "029709101"));
        data.add(new Data("산학협력단 - 감사팀","02-970-9103", "029709103"));
        data.add(new Data("입학관리본부 - 입학관리팀","02-970-6832", "029706832"));
        data.add(new Data("입학관리본부 - 입학전형팀","02-970-6842", "029706842"));
        data.add(new Data("홍보실","02-970-6992", "029706992"));


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
