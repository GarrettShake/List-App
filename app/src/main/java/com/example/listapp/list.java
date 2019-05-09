package com.example.listapp;


class list {

    private String title1, desc1;

    list(String title, String desc){

        title1=title;
        desc1=desc;
    }

    public list() {
    }

    String getTitle1(){
        return title1;
    }
    String getDesc1(){
        return desc1;
    }
}
