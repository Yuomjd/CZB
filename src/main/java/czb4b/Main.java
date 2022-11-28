package czb4b;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int i = 0;
        int day = 0;
        while(next.charAt(i) <= '9' && next.charAt(i) >= '0'){
            day = day * 10 + (next.charAt(i) - '0');
            i++;
        }
        String substring = next.substring(i, 3);
        System.out.println(substring);
        System.out.println(day);
    }
}