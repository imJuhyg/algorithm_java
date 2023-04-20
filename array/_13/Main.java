package array._13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Least Recently Used
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        int[] cache = new int[S];
        for(int i=0; i<arr.length; i++) {
            // 캐시에 작업이 이미 존재하는지 찾기
            int pos = -1;
            for(int j=0; j<cache.length; j++) {
                if(arr[i] == cache[j]) {
                    pos = j;
                    break;
                }
            }

            if(pos != -1) {
                // 캐시에 이미 존재하는 작업 제외시키기
                for(int j=pos; j>0; j--) {
                    cache[j] = cache[j-1];

                }
            }
            else {
                for(int j=cache.length-1; j>0; j--) {
                    cache[j] = cache[j-1];
                }
            }
            cache[0] = arr[i];
        }
        StringBuilder answer = new StringBuilder();
        for(int task : cache) answer.append(task).append(" ");
        System.out.println(answer);
    }
}