package czb4b;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class P8844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int w = scanner.nextInt();
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i]<=w){
                w = nums[i];
                break;
                }
            }
        int count = 0;
        for (int num : nums) {
            if (num <= w) {
                count++;
                w -= num;
            } else {
                break;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
