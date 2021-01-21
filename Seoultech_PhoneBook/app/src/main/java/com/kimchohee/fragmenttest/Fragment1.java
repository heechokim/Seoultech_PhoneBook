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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private Intent intent;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_right2, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_right2);
        recyclerView.setHasFixedSize(true); // 리사이클러뷰를 고정시켜준다.
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
        /* 총장실 */
        data.add(new Data("총장실","02-970-6000", "029706000"));
        data.add(new Data("비서실장","02-970-6001", "029706001"));
        data.add(new Data("비서실","02-970-6001~2", "029706001"));
        /* 공과대학 */
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
        /* 미래융합대학 */
        data.add(new Data("제1행정실","02-970-9783", "029709783"));
        data.add(new Data("융합기계공학과","02-970-9721", "029709721"));
        data.add(new Data("건설환경융합공학과","02-970-6571", "029706571"));
        data.add(new Data("헬스케어학과","02-970-9741", "029709741"));
        data.add(new Data("문화예술학과","02-970-9751", "029709751"));
        data.add(new Data("영미문화학과","02-970-9761", "029709761"));
        data.add(new Data("벤처경영학과","02-970-9771", "029709771"));
        /* 메이커스칼리지 */
        data.add(new Data("메이커스칼리지","02-970-9250", "029709250"));
        /* 정보통신대학 */
        data.add(new Data("제2행정실","02-970-6191", "029706191"));
        data.add(new Data("전기정보공학과","02-970-6402", "029706402"));
        data.add(new Data("전자IT미디어공학과","02-970-6452", "029706452"));
        data.add(new Data("컴퓨터공학과","02-970-6707", "029706707"));
        /* 에너지바이오대학 */
        data.add(new Data("제2행정실","02-970-6193", "029706193"));
        data.add(new Data("화공생명공학과","02-970-6601", "029706601"));
        data.add(new Data("환경공학과","02-970-6623", "029706623"));
        data.add(new Data("식품공학과","02-970-6732", "029706732"));
        data.add(new Data("정밀화학과","02-970-6682", "029706682"));
        data.add(new Data("스포츠과학과","02-970-6367", "029706367"));
        data.add(new Data("안경광학과","02-970-3225", "029703225"));
        /* 조형대학 */
        data.add(new Data("제3행정실","02-970-6201", "029706201"));
        data.add(new Data("디자인학과","02-970-6667", "029706667"));
        data.add(new Data("도예학과","02-970-6618", "029706618"));
        data.add(new Data("금속공예디자인학과","02-970-6664", "029706664"));
        data.add(new Data("조형예술학과","02-970-6635", "029706636"));
        data.add(new Data("시각문화융합디자인학과","02-970-6674", "029706674"));
        /* 인문사회대학 */
        data.add(new Data("제3행정실","02-970-6751", "029706751"));
        data.add(new Data("영어영문학과","02-970-6377", "029706377"));
        data.add(new Data("행정학과","02-970-6489", "029706489"));
        data.add(new Data("문예창작학과","02-970-6291", "029706291"));
        data.add(new Data("기초교육학부","02-970-6251", "029706251"));
        /* 기술경영융합대학 */
        data.add(new Data("제3행정실","02-970-6753", "029706753"));
        data.add(new Data("산업정보시스템전공","02-970-6482", "029706482"));
        data.add(new Data("MSDE 전공","02-970-6932", "029706932"));
        data.add(new Data("ITM 전공","02-970-7279", "029707279"));
        data.add(new Data("경영학과 - 경영학전공","02-970-6477", "029706477"));
        data.add(new Data("경영학과 - GTM 전공","02-970-7284", "029707284"));
        /* 대학원 */
        data.add(new Data("제4행정실 - 일반행정팀","02-970-6793", "029706793"));
        data.add(new Data("제4행정실 - 학사지원팀","02-970-6799", "029706799"));
        /* 행정부서 */
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
        /* 교육지원/부속시설 */
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
        /* 학생자치기구 */
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
        /* 후생복지시설 */
        data.add(new Data("우체국","02-970-6911", "029706911"));
        data.add(new Data("농협","02-970-5104", "029705104"));
        data.add(new Data("제1식당","02-970-6915", "029706915"));
        data.add(new Data("제2식당","02-970-6919", "029706919"));
        data.add(new Data("서울테크노파크식당","02-970-6991", "029706991"));
        data.add(new Data("정문정산소","02-970-6109", "029706109"));
        data.add(new Data("창의문정산소","02-970-6110", "029706110"));
        data.add(new Data("서점","02-970-6916", "029706916"));
        data.add(new Data("화방","02-970-3939", "029703939"));
        data.add(new Data("안경점","02-970-6918", "029706918"));
        data.add(new Data("SeoulTech 어린이집","02-970-9389", "029709389"));
        data.add(new Data("제1복사실","02-970-6913", "029706913"));
        data.add(new Data("제2복사실","02-970-6964", "029706964"));
        data.add(new Data("미용실","02-970-6242", "029706242"));
        data.add(new Data("국민은행","02-970-5082", "029705082"));
        data.add(new Data("생협","02-970-9135", "029709135"));
        data.add(new Data("투오브어스","02-970-8681", "029708681"));

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

    public ArrayList<Data> getArrayList(){
        for(int i = 0 ; i < data.size() ; i++)
            Log.d("chohee", data.get(i).getString());

        return data;
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