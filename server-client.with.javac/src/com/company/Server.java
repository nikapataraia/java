package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket aa = new ServerSocket(1000);
        Socket a = aa.accept();
        System.out.println("connected");
    }
}
