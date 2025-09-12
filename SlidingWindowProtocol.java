package com.smvitm.cnlab;
import java.util.Scanner;
public class SlidingWindowProtocol {
private int windowsize;
private int[] frames;
private boolean[] ack;
public SlidingWindowProtocol(int windowsize,int framecount){
  this.windowsize=windowsize;
  this.frames=new int[framecount];
  this.ack=new boolean[framecount];
  for(int i=0;i<framecount;i++){
      frames[i]=i;
      ack[i]=false;
  }
}
public void sendframes(){
    int sendIndex=0;
while(sendIndex<frames.length){
    for(int i=0;i<windowsize && (sendIndex+i)<frames.length;i++){
        System.out.println("sending frame:"+frames[sendIndex+i]);
    }
    for(int i=0;i<windowsize && (sendIndex+i)<frames.length;i++){
       ack[sendIndex+i]=reciveack(sendIndex+i);
    }
while(sendIndex<frames.length && ack[sendIndex]){
    sendIndex++;
}
while(sendIndex<frames.length && ack[sendIndex]){
    sendIndex++;
}
}
}
private boolean reciveack(int frame){
    System.out.println("Reciving ack for frame:"+frame);
    return true;
}
public static void main(String[] args) {
    int windowsize=4;
    int framecount=10;
    
    SlidingWindowProtocol swp=new
    SlidingWindowProtocol(windowsize,framecount);
swp.sendframes();
}
}
