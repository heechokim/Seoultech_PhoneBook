package com.example.fragmenttest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
// 검색을 위해 두 개 더 임포트 때림
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerviewLayoutmanager;
    private ArrayList<Data> data = new ArrayList<>();
    private MyAdapter myAdapter;

    // 검색을 위한 것들 조져보자
    private ArrayList<Data> dataList = new ArrayList<>();

    private FilterAdapter filterAdapter ;
    RecyclerView filterView;
    EditText editsearch;
    LinearLayoutManager mLayoutManager;

    FragmentManager fm;
    FragmentTransaction tran;
    Fragment0 fragment0;
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

        // 검색을 위해 조진 것
        dataList.clear();

//        /* 총장실 */
//        dataList.add(new Data("총장실","02-970-6000", "029706000"));
//        dataList.add(new Data("비서실장","02-970-6001", "029706001"));
//        dataList.add(new Data("비서실","02-970-6001~2", "029706001"));
//        /* 공과대학 */
//        dataList.add(new Data("제1행정실 - 행정지원팀","02-970-6172", "029706172"));
//        dataList.add(new Data("제1행정실 - 교무학생팀","02-970-6183", "029706183"));
//        dataList.add(new Data("제1행정실 - 실험실습지원팀","02-970-6178", "029706178"));
//        dataList.add(new Data("기시디 - 기계설계자동화","02-970-6351", "029706351"));
//        dataList.add(new Data("기시디 - 기계디자인금형공학","02-970-6306", "029706306"));
//        dataList.add(new Data("기계자동차공학과 - 기계프로그램","02-970-6303", "029706303"));
//        dataList.add(new Data("기계자동차공학과 - 자동차프로그램","02-970-6334", "029706334"));
//        dataList.add(new Data("안전공학과","02-970-6372", "029706372"));
//        dataList.add(new Data("신소재공학과","02-970-6637", "029706637"));
//        dataList.add(new Data("건설시스템공학과","02-970-6501", "029706501"));
//        dataList.add(new Data("토목산업공학과","번호 없음", "번호 없음"));
//        dataList.add(new Data("건축학부 - 건축공학전공","02-970-6551", "029706551"));
//        dataList.add(new Data("건축학부 - 건축학전공","02-970-6562", "029706562"));
//        dataList.add(new Data("건축산업학과","02-970-6826", "029706826"));
//        dataList.add(new Data("기계설비공학과","02-970-6828", "029706828"));
//        dataList.add(new Data("시설물유지관리공학과","02-970-6565", "029706565"));
//        dataList.add(new Data("플랜트엔지니어링학과","02-970-6828", "029706828"));
//        dataList.add(new Data("건축환경설비공학과","02-970-6565", "029706565"));
//        dataList.add(new Data("철도아카데미","02-970-6885", "029706885"));
//        /* 미래융합대학 */
//        dataList.add(new Data("제1행정실","02-970-9783", "029709783"));
//        dataList.add(new Data("융합기계공학과","02-970-9721", "029709721"));
//        dataList.add(new Data("건설환경융합공학과","02-970-6571", "029706571"));
//        dataList.add(new Data("헬스케어학과","02-970-9741", "029709741"));
//        dataList.add(new Data("문화예술학과","02-970-9751", "029709751"));
//        dataList.add(new Data("영미문화학과","02-970-9761", "029709761"));
//        dataList.add(new Data("벤처경영학과","02-970-9771", "029709771"));
//        /* 메이커스칼리지 */
//        dataList.add(new Data("메이커스칼리지","02-970-9250", "029709250"));
//        /* 정보통신대학 */
//        dataList.add(new Data("제2행정실","02-970-6191", "029706191"));
//        dataList.add(new Data("전기정보공학과","02-970-6402", "029706402"));
//        dataList.add(new Data("전자IT미디어공학과","02-970-6452", "029706452"));
//        dataList.add(new Data("컴퓨터공학과","02-970-6707", "029706707"));
//        /* 에너지바이오대학 */
//        dataList.add(new Data("제2행정실","02-970-6193", "029706193"));
//        dataList.add(new Data("화공생명공학과","02-970-6601", "029706601"));
//        dataList.add(new Data("환경공학과","02-970-6623", "029706623"));
//        dataList.add(new Data("식품공학과","02-970-6732", "029706732"));
//        dataList.add(new Data("정밀화학과","02-970-6682", "029706682"));
//        dataList.add(new Data("스포츠과학과","02-970-6367", "029706367"));
//        dataList.add(new Data("안경광학과","02-970-3225", "029703225"));
//        /* 조형대학 */
//        dataList.add(new Data("제3행정실","02-970-6201", "029706201"));
//        dataList.add(new Data("디자인학과","02-970-6667", "029706667"));
//        dataList.add(new Data("도예학과","02-970-6618", "029706618"));
//        dataList.add(new Data("금속공예디자인학과","02-970-6664", "029706664"));
//        dataList.add(new Data("조형예술학과","02-970-6635", "029706636"));
//        dataList.add(new Data("시각문화융합디자인학과","02-970-6674", "029706674"));
//        /* 인문사회대학 */
//        dataList.add(new Data("제3행정실","02-970-6751", "029706751"));
//        dataList.add(new Data("영어영문학과","02-970-6377", "029706377"));
//        dataList.add(new Data("행정학과","02-970-6489", "029706489"));
//        dataList.add(new Data("문예창작학과","02-970-6291", "029706291"));
//        dataList.add(new Data("기초교육학부","02-970-6251", "029706251"));
//        /* 기술경영융합대학 */
//        dataList.add(new Data("제3행정실","02-970-6753", "029706753"));
//        dataList.add(new Data("산업정보시스템전공","02-970-6482", "029706482"));
//        dataList.add(new Data("MSDE 전공","02-970-6932", "029706932"));
//        dataList.add(new Data("ITM 전공","02-970-7279", "029707279"));
//        dataList.add(new Data("경영학과 - 경영학전공","02-970-6477", "029706477"));
//        dataList.add(new Data("경영학과 - GTM 전공","02-970-7284", "029707284"));
//        /* 대학원 */
//        dataList.add(new Data("제4행정실 - 일반행정팀","02-970-6793", "029706793"));
//        dataList.add(new Data("제4행정실 - 학사지원팀","02-970-6799", "029706799"));
//        /* 행정부서 */
//        dataList.add(new Data("교무처 - 교무팀","02-970-6024", "029706024"));
//        dataList.add(new Data("교무처 - 학사지원팀","02-970-2034", "029702034"));
//        dataList.add(new Data("학생처 - 학생지원팀","02-970-6044", "029706044"));
//        dataList.add(new Data("학생처 - 장학복지팀","02-970-6052", "029706052"));
//        dataList.add(new Data("학생처 - 보건진료소","02-970-7199", "029707199"));
//        dataList.add(new Data("기획처 - 기획평가과 기획팀","02-970-6064", "029706064"));
//        dataList.add(new Data("기획처 - 기획평가과 평가팀","02-970-6072", "029706072"));
//        dataList.add(new Data("사무국 - 총무과 총무팀","02-970-6092", "029706092"));
//        dataList.add(new Data("사무국 - 총무과 인사팀","02-970-6112", "029706112"));
//        dataList.add(new Data("사무국 - 재무과 재무1팀","02-970-6122", "029706122"));
//        dataList.add(new Data("사무국 - 재무과 재무2팀","02-970-6128", "029706128"));
//        dataList.add(new Data("사무국 - 시설과 시설총괄팀","02-970-6142", "029706142"));
//        dataList.add(new Data("사무국 - 시설과 시설관리팀","02-970-6145", "029706145"));
//        dataList.add(new Data("사무국 - 시설과 전기지원팀","02-970-6148", "029706148"));
//        dataList.add(new Data("사무국 - 시설과 기계지원팀","02-970-6152", "029706152"));
//        dataList.add(new Data("사무국 - 시설과 토목조경팀","02-970-6154", "029706154"));
//        dataList.add(new Data("사무국 - 예비군연대","02-970-6082", "029706082"));
//        dataList.add(new Data("산학협력단 - 정책기획팀","02-970-9082", "029709082"));
//        dataList.add(new Data("산학협력단 - 재무회계팀","02-970-9121", "029709121"));
//        dataList.add(new Data("산학협력단 - 기술사업화팀","02-970-9156", "029709156"));
//        dataList.add(new Data("산학협력단 - 미래전략기획단","02-970-9247", "029709247"));
//        dataList.add(new Data("산학협력단 - 학술연구진흥팀","02-970-9138", "029709138"));
//        dataList.add(new Data("산학협력단 - 연구관리1팀","02-970-9126", "029709126"));
//        dataList.add(new Data("산학협력단 - 연구관리2팀","02-970-9101", "029709101"));
//        dataList.add(new Data("산학협력단 - 감사팀","02-970-9103", "029709103"));
//        dataList.add(new Data("입학관리본부 - 입학관리팀","02-970-6832", "029706832"));
//        dataList.add(new Data("입학관리본부 - 입학전형팀","02-970-6842", "029706842"));
//        dataList.add(new Data("홍보실","02-970-6992", "029706992"));
//        /* 교육지원/부속시설 */
//        dataList.add(new Data("도서관 - 학술정보지원팀","02-970-9031", "029709031"));
//        dataList.add(new Data("도서관 - 학술정보서비스팀","02-970-9041", "029709041"));
//        dataList.add(new Data("도서관 - 학술정보미디어팀","02-970-9039", "029709039"));
//        dataList.add(new Data("정보전산원 - 정보화기획팀","02-970-9052", "029709052"));
//        dataList.add(new Data("정보전산원 - 학사정보화팀","02-970-9057", "029709057"));
//        dataList.add(new Data("정보전산원 - 일반정보화팀","02-970-9055", "029709055"));
//        dataList.add(new Data("정보전산원 - 정보인프라팀","02-970-9064", "029709064"));
//        dataList.add(new Data("생활관","02-970-9141", "029709141"));
//        dataList.add(new Data("공동실험실습관 - 교육지원팀","02-970-7231", "029707231"));
//        dataList.add(new Data("공동실험실습관 - 실습연구지원팀","02-970-7235", "029707235"));
//        dataList.add(new Data("인재개발원 - 학생취업지원팀","02-970-9001", "029709001"));
//        dataList.add(new Data("인재개발원 - 학생생활상담팀","02-970-9006", "029709006"));
//        dataList.add(new Data("인재개발원 - 현장실습지원센터","02-970-6858", "029706858"));
//        dataList.add(new Data("성평등상담센터 - 성평등상담팀","02-970-9008", "029709008"));
//        dataList.add(new Data("기록관","02-970-9161", "029709161"));
//        dataList.add(new Data("신문방송사 - 신문사","02-970-9174", "029709174"));
//        dataList.add(new Data("신문방송사 - 방송국","02-970-9177", "029709177"));
//        dataList.add(new Data("국제교육본부 - 국제교류팀","02-970-9221", "029709221"));
//        dataList.add(new Data("국제교육본부 - 한국어교육팀","02-970-9219", "029709219"));
//        dataList.add(new Data("국제교육본수 - 어학교육팀","02-970-7203", "029707203"));
//        dataList.add(new Data("대학교육혁신원 - 교육정책연구센터","02-970-9312", "029709312"));
//        dataList.add(new Data("대학교육혁신원 - 교수학습개발센터","02-970-9251", "029709251"));
//        dataList.add(new Data("대학교육혁신원 - 공학교육혁신센터","02-970-9235", "029709235"));
//        dataList.add(new Data("대학교육혁신원 - 교양교육연구센터","02-970-9312", "029709312"));
//        dataList.add(new Data("창업지원단 - 창업보육센터","02-970-9022", "029709022"));
//        dataList.add(new Data("창업지원단 - 창업교육센터","02-970-9151", "029709151"));
//        dataList.add(new Data("산학협력선도대학사업단","02-970-9121", "029709121"));
//        dataList.add(new Data("장애학생지원센터","02-970-6054", "029706054"));
//        dataList.add(new Data("미술관","02-970-6215", "029706215"));
//        dataList.add(new Data("성평등상담센터","02-970-9006", "029709006"));
//        dataList.add(new Data("학생군사교육단(ROTC)","02-970-9274", "029709274"));
//        dataList.add(new Data("(재)서울과학기술대학교 발전기금","02-970-9263", "029709263"));
//        dataList.add(new Data("노원과학영재교육원","02-970-9281", "029709281"));
//        /* 학생자치기구 */
//        dataList.add(new Data("총학생회실","02-970-7011", "029707011"));
//        dataList.add(new Data("총졸업준비위원회","02-970-7019", "029707019"));
//        dataList.add(new Data("교지편집실","02-970-7020", "029707020"));
//        dataList.add(new Data("동아리연합회","02-970-7022", "029707022"));
//        dataList.add(new Data("학생복지위원회","02-970-7023", "029707023"));
//        dataList.add(new Data("공과대학","02-970-7044", "029707044"));
//        dataList.add(new Data("정보통신대학/에너지바이오대학","02-970-7050", "029707050"));
//        dataList.add(new Data("조형대학","02-970-7055", "029707055"));
//        dataList.add(new Data("인문사회대학","02-970-7061", "029707061"));
//        dataList.add(new Data("기술경영융합대학","02-970-7015", "029707015"));
//        /* 후생복지시설 */
//        dataList.add(new Data("우체국","02-970-6911", "029706911"));
//        dataList.add(new Data("농협","02-970-5104", "029705104"));
//        dataList.add(new Data("제1식당","02-970-6915", "029706915"));
//        dataList.add(new Data("제2식당","02-970-6919", "029706919"));
//        dataList.add(new Data("서울테크노파크식당","02-970-6991", "029706991"));
//        dataList.add(new Data("정문정산소","02-970-6109", "029706109"));
//        dataList.add(new Data("창의문정산소","02-970-6110", "029706110"));
//        dataList.add(new Data("서점","02-970-6916", "029706916"));
//        dataList.add(new Data("화방","02-970-3939", "029703939"));
//        dataList.add(new Data("안경점","02-970-6918", "029706918"));
//        dataList.add(new Data("SeoulTech 어린이집","02-970-9389", "029709389"));
//        dataList.add(new Data("제1복사실","02-970-6913", "029706913"));
//        dataList.add(new Data("제2복사실","02-970-6964", "029706964"));
//        dataList.add(new Data("미용실","02-970-6242", "029706242"));
//        dataList.add(new Data("국민은행","02-970-5082", "029705082"));
//        dataList.add(new Data("생협","02-970-9135", "029709135"));
//        dataList.add(new Data("투오브어스","02-970-8681", "029708681"));

        leftList();
        fragment0 = new Fragment0();
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
        setFragment(-1);
        setFragment(0);

        // 검색 조지기
        editsearch =(EditText)findViewById(R.id.et_search);

        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editsearch.getText().toString()
                        .toLowerCase(Locale.getDefault());
                if(text.length() != 0) {
                    fragment0.myAdapter.filter(text);
                    setFragment(-1);
                }
                else{
                    setFragment(0);
                }

            }
        });
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
            case -1:
                tran.replace(R.id.framelayout_right, fragment0);
                tran.commit();
                break;

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
