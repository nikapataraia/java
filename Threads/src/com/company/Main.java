package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
public class Main {
    public static class mycal implements Callable<Integer> {
        public static int count;
        public int[] myarray = new int[count+1];
        public mycal(){
            count++;
            for(int i =0; i < count; i++){
                myarray[i] = i;
            }
        }
        @Override
        public Integer call() throws Exception {
            System.out.println(count);
            return count;
        }
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Callable<Integer> a ;
        ForkJoinPool b = new ForkJoinPool();
        Thread c = new Thread();
        Thread d = new Thread();
        System.out.println(Thread.currentThread().getName());

    }
}

