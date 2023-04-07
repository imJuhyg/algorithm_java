package array._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 보이는 학생
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0; i<input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int count = 1;
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                count++;
            }
        }
        System.out.println(count);
    }
}