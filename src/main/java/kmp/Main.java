package kmp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        while(i > 0){
            int aLength = scanner.nextInt();
            int bLength = scanner.nextInt();
            String aString = scanner.next();
            String bString = scanner.next();
            aString = aString.toUpperCase();
            bString = bString.toUpperCase();
            char [] aChars = new char[aLength];
            aString.getChars(0,aLength,aChars,0);
            char [] bChars = new char[bLength];
            bString.getChars(0,bLength,bChars,0);
            Integer kmp = kmp(aChars, bChars);
            System.out.println(kmp);
            i--;
        }
    }
    private static Integer kmp(char [] aChars,char [] bChars){
        if(aChars.length == bChars.length){
            for (int i = 0; i < aChars.length; i++) {
                if(aChars[i] != bChars[i]) {
                    return 0;
                }
            }
            return 1;
        }
        int count = 0;
        String aString = new String(aChars);
        int right = aChars.length;
        int j = 0;
        for (int i = right; true;) {
            /**
             * 如果 b 数组左偏移后的长度小于 a 数组 那么停止
             */
            if(bChars.length - j < aChars.length)
                break;
            String s = new String(bChars,j,i);
            if(aString.equals(s)){
                count++;
            }
            j++;
        }
        return count;
    }
}
