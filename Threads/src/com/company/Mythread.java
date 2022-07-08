package com.company;

public class Mythread extends Thread{
    public Mythread(Myrunnable myrunnable) {
        myrunnable.run();
    }

    public void run(){
        this.run();
    }
}
