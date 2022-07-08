package com.company;

public class Myrunnable implements Runnable{
    public int a;
    public String b;
    public static int c;
    public Myrunnable(int a, String b){
        this.a = a;
        this.b = b;
        c++;
        this.run();
    }
    @Override
    public void run() {
        System.out.println(a + b);
    }
}
