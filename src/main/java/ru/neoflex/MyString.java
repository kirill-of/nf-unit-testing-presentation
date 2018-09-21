package ru.neoflex;

public class MyString {
    private String str;

    public MyString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void print() {
        System.out.println(str);
    }
}