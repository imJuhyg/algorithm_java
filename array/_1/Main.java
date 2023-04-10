package array._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 큰 수 출력하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        StringBuilder answer = new StringBuilder();
        int[] nums = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        answer.append(nums[0]).append(" ");
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) answer.append(nums[i]).append(" ");
        }

        System.out.println(answer);

    }
}
