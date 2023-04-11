package sliding_window._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대 매출
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[input2.length];

        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = start+K;
        while(true) {
            if(end > N) break;

            int sum = 0;
            for(int j=start; j<end; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
            start++;
            end++;
        }
        System.out.println(max);
    }
}
