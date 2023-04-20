package hash._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 중복 확인(HashSet)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        HashSet<Integer> set = new HashSet<>();
        boolean isDuplication = false;
        for(int num : arr) if(!set.add(num)) isDuplication = true;
        String answer = isDuplication ? "D" : "U";
        System.out.println(answer);
    }
}
