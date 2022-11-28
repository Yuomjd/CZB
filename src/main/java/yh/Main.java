package yh;

import java.util.Scanner;


public class Main {

    static boolean[] st;
    static int[] primes;
    static int N = 2000010;
    static {
        st = new boolean[N];
        primes = new int[N];
        st[0] = st[1] = true;
        int cnt = 1;
        for (int i = 2; i < N; i++) {
            if(!st[i]){
                primes[cnt++] = i;
                for (int j = i * i; j < N; j++) {
                    st[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        while( i > 0){
            int x = scanner.nextInt();
            int result = getCount(x);
            System.out.println(result);
            i--;
        }
    }
    private static Integer getCount(Integer x){
        Integer res = 0;
        for (int i = x; i > 0; i++) {
            int y = x ^ i;
            if(isPrime(y)){
                res++;
            }
        }
        return res;
    }
    private static boolean isPrime(Integer y){
        return st[y];
    }
}
