package com.csust.utils;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.csust.dao.YaoDAOImpl;
import com.csust.views.InGoodsInfor;
import com.csust.views.SellDia;



public class SimpleCommIO implements Runnable {

    static CommPortIdentifier portId;
    static String cmdHand = "I\r\n";
    static String cmdWeight = "WX\r\n";
    static SerialPort serialPort;
    static OutputStream outputStream;
 
    static String comm="COM3";

    InputStream inputStream;
 
    Thread readThread;
    
    public void run() {
        while (true) {
            try {
                byte[] readBuffer = new byte[10];

                try {
                    while (inputStream.available() > 0) {
                        int numBytes = inputStream.read(readBuffer);
                        String hex = str2HexStr(new String(readBuffer,0,numBytes));
                        System.out.println("收到数据："+hex);
                    
                        if(SellDia.jTextField1!=null){
                        	String name = new YaoDAOImpl().getYaoName(hex);
                        	SellDia.jTextField1.setText(name);
                        }
                        
                        if(InGoodsInfor.jTextField1!=null){
                        	InGoodsInfor.jTextField1.setText(hex);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    public String str2HexStr(String str) {    
        char[] chars = "0123456789ABCDEF".toCharArray();    
        StringBuilder sb = new StringBuilder("");  
        byte[] bs = str.getBytes();    
        int bit;    
        for (int i = 0; i < bs.length; i++) {    
            bit = (bs[i] & 0x0f0) >> 4;    
            sb.append(chars[bit]);    
            bit = bs[i] & 0x0f;    
            sb.append(chars[bit]);    
        }    
        return sb.toString();    
    }

    public void initComm() {
        try{
            portId = CommPortIdentifier.getPortIdentifier(comm);
            serialPort = (SerialPort) portId.open("SimpleCommIO",2000);

            outputStream = serialPort.getOutputStream();
            inputStream = serialPort.getInputStream();

            serialPort.setSerialPortParams(9600,
                    SerialPort.DATABITS_8, 
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void writeComm(String cmd) {
        try {
            outputStream.write(cmd.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
    public static void getHex(){
        SimpleCommIO reader = new SimpleCommIO();
        reader.initComm();
        Thread readThread = new Thread(reader);
        readThread.start();
        System.out.println("发出指令："+cmdHand);
        reader.writeComm(cmdHand);
        
        //暂停一会儿
        try { 
            Thread.sleep ( 1000 ) ; 
        } catch (InterruptedException ie)
        {
            
        }
        System.out.println("发出指令："+cmdWeight);
        reader.writeComm(cmdWeight);
//    }
    }
}
