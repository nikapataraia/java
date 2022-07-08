package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends MiniJava{
    public static void main(String[] args)throws IOException {
        Socket sock = new Socket("localhost",4999);
        MyFrame myFrame = new MyFrame();
        System.out.println("From client:Connected to server");

        //send
        PrintWriter pr = new PrintWriter(sock.getOutputStream());
        TextThread textThread = new TextThread(pr,myFrame);
        textThread.start();
        //

        //get input
        InputStreamReader in = new InputStreamReader(sock.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        GetInputThread getInputThread = new GetInputThread(bf,"Client",myFrame);
        getInputThread.start();
        //

    }

}
