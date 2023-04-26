package backtracking._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *[BOJ]N과 M(2)(15650)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        for(int i=1; i<=N; i++) {
            arr[i-1] = i;
        }
        combination(arr, 0, M, new StringBuilder());
    }

    static void combination(int[] arr, int pos, int M, StringBuilder result) {
        if(pos == arr.length) {
            if(result.length() == M) {
                for(int i=0; i<result.length(); i++) {
                    System.out.print(result.charAt(i)+ " ");
                }
                System.out.println();
            }
            return;
        }

        combination(arr, pos+1, M, result.append(arr[pos])); // 선택하고
        result.setLength(result.length()-1); // 돌아와서
        combination(arr, pos+1, M, result); // 선택안하고
    }
}
