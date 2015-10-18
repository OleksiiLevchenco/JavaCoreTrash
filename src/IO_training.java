package com.gmail.polyride;

import java.io.*;

public class IO_training {
    public static int count=0;

    public static void copy(InputStream src,OutputStream dst) throws IOException{
        int data;
        for(;;){
            data = src.read();
            if (data==-1) return;
            dst.write(data);
            count++;
        }
    }

    public static void copyFileNoBuff() throws IOException {
        count=0;
        long start = System.nanoTime();
        String fileName = "Pod-Oshva.exe";
        InputStream src;
        try {
            src =new FileInputStream("D:"+fileName);
        }catch (IOException e){
            System.err.println("Не правилное имя файла "+e);
            throw e;
        }

        OutputStream dst=new FileOutputStream("D:test"+fileName);
        copy(src,dst);
        long end = System.nanoTime();
        System.out.println("time,s= "+ ((end-start)/(float)1000000000)+" Count,B= "+count);
    }

    public static void copyFileBuff() throws IOException {
        count=0;
        long start = System.nanoTime();
        String fileName = "Pod-Oshva.exe";
        InputStream src;
        try {
            src =new FileInputStream("D:"+fileName);
        }catch (IOException e){
            System.err.println("Не правилное имя файла "+e);
            throw e;
        }
        OutputStream dst=new FileOutputStream("D:test"+fileName);
        BufferedInputStream in = new BufferedInputStream(src);
        BufferedOutputStream out = new BufferedOutputStream(dst);
        copy(in,out);
        long end = System.nanoTime();
        System.out.println("time,s= "+ ((end-start)/(float)1000000000)+" Count,B= "+count);
    }




}