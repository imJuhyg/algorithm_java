package hash._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// *매출액의 종류
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        int start = 0;
        int end = K-1;
        for(int i=start; i<=end; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        answer.append(map.size()).append(" ");
        start++;
        end++;


        while(true) {
            if(end >= N) break;
            map.put(arr[start-1], map.get(arr[start-1])-1); // 빼기

            if(map.get(arr[start-1]) == 0) map.remove(arr[start-1]);
            map.put(arr[end], map.getOrDefault(arr[end], 0)+1);

            answer.append(map.size()).append(" ");
            start++;
            end++;
        }
        System.out.println(answer);
    }
}
