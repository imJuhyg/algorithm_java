package backtracking._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 바둑이 승차(조합)
public class Main {
    static int C;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        C = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        combination(arr, 0, new ArrayList<>());
        System.out.println(max);
    }

    static void combination(int[] arr, int pos, ArrayList<Integer> sumList) {
        int sum =0;
        for(int s : sumList) sum += s;

        if(pos == arr.length && sum <= C) {
            max = Math.max(max, sum);
            return;
        }

        if(sum > C) { // 용량을 넘기면 max 계산하지 않고 그냥 return
            return;
        }

        sumList.add(arr[pos]);
        combination(arr, pos+1, sumList);
        sumList.remove(sumList.size()-1);
        combination(arr, pos+1, sumList);
    }
}
