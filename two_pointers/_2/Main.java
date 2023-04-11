package two_pointers._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 합친 후 정렬
        // 2. 같은 원소가 두개 씩 나오면 answer 배열에 넣음

        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");

        int[] arr = new int[N+M];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input1[i]);
        }
        for(int i=N; i<N+M; i++) {
            arr[i] = Integer.parseInt(input2[i-N]);
        }
        Arrays.sort(arr);

        StringBuilder answer = new StringBuilder();
        int pre = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == pre) {
                answer.append(arr[i]).append(" ");
            }
            pre = arr[i];
        }
        System.out.println(answer);
    }
}
