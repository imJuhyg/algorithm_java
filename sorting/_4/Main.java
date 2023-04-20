package sorting._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 장난꾸러기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 정렬 이용
        int[] copyArray = arr.clone(); // deep copy
        Arrays.sort(copyArray);
        for(int i=0; i<N; i++) {
            if(arr[i] != copyArray[i]) System.out.print(i+1+" ");
        }

    }
}
