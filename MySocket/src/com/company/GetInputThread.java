package com.company;

import java.io.BufferedReader;
import java.io.IOException;

public class GetInputThread extends Thread{
    BufferedReader bf;
    String from;
    MyFrame myFrame;

    public GetInputThread(BufferedReader bf,String from,MyFrame myFrame){
        this.bf = bf;
        this.from = from;
        this.myFrame = myFrame;
    }
    @Override
    public void run() {
        String inputString = "";
        while(true){
            while(true) {
                try {
                    inputString = bf.readLine();
                    break;
                } catch (IOException e) {
                    //try again
                }
            }
            myFrame.setLabelOther(inputString);
        }
    }
}
