package com.zht.utils;

public class toInteger {
    private toInteger(){

    }
    public static Integer parseInteger(String s){
        if(s==null){
            s = "";
        }
        Integer num = null;
        if(!(s.equals("")||s.equals("0"))){
            num = Integer.parseInt(s);
        }
        return num;
    }
}
