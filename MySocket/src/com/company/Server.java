package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.BreakIterator;

public class Server extends MiniJava{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSock = new ServerSocket(4999);
        Socket sock = serverSock.accept();
        System.out.println("From server: client connected");
        MyFrame myFrame = new MyFrame();
        //get input
        InputStreamReader in = new InputStreamReader(sock.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        GetInputThread getInputThread = new GetInputThread(bf,"server",myFrame);
        getInputThread.start();
        //

        //send
        PrintWriter pr = new PrintWriter(sock.getOutputStream());
        TextThread textThread = new TextThread(pr,myFrame);
        textThread.start();
        //

    }
}
