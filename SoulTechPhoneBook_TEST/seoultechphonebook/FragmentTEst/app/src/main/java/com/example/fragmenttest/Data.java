package com.example.fragmenttest;

public class Data {
    String string;
    String phonenum;
    String call;

    public String getCall() {
        return call;
    }

    public Data(String string, String phonenum, String call) {
        this.string = string;
        this.phonenum = phonenum;
        this.call = call;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public String getPhonenum() {
        return phonenum;
    }
}

/** 데이터 클래스 작성하기
 * 1. 리사이클러뷰의 각 리스트에 들어갈 데이터들을 객체로 한꺼번에 받는 클래스이다.
 * 2. 데이터들을 받을 변수를 선언한다.
 * 3. 각 변수를 모두 포함하는 생성자를 생성한다.
 * 4. 각 변수마다 getter, setter 을 생성한다.
 * */
