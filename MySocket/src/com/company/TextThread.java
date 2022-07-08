package com.company;

import java.io.PrintWriter;

public class TextThread extends Thread{
    PrintWriter pr;
    MyFrame myFrame;


    public TextThread(PrintWriter pr,MyFrame myFrame){
        this.pr = pr;
        this.myFrame = myFrame;
    }

    @Override
    public void run() {
        String inputToSend = "";
        while (true){
            while (true){

                if(myFrame.isReadyToGetText()){
                    inputToSend = myFrame.getText();
                    System.out.println(inputToSend);
                    break;
                }

            }

            pr.println(inputToSend);
            pr.flush();
            myFrame.setLabelOur(inputToSend);
        }

    }
}
