package com.algo;

public class StringEncoding {
    public static void main(String[] args) {
        String str="a23c41";

        char[] ch=str.toCharArray();
        for(int i=0;i<=ch.length-3;i=i+3){
            int min,max=0;
            if(ch[i+1]>ch[i+2]){
                min=ch[i+2]-48;
                max=ch[i+1]-48;
            }else{
                min=ch[i+1]-48;
                max=ch[i+2]-48;
            }

            char s=(char)(ch[i]+min);
            for(int j=0;j<max;j++){
                System.out.print(s);
            }

        }
    }
}
