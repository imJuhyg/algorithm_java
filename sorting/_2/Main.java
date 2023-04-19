package sorting._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 버블 정렬
 * 1. 배열의 첫 번째 원소부터 인접한 원소끼리 비교/교환 한다.
 * 2. 마지막 원소까지 비교했으면 마지막 원소는 정렬이 완료된 원소이다.
 * 3. 마지막 원소를 제외하고 1로 되돌아간다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Sorting
        boolean isSorted = false;
        int end = N;
        while(!isSorted) { // 이미 완료되어있는 정렬은 더 이상 탐색하지 않는다. (최선 -> o(n))
            isSorted = true;
            for(int i=0; i<end-1; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    isSorted = false;
                }
            }
            end--;
        }

        StringBuilder answer = new StringBuilder();
        for(int i : arr) answer.append(i).append(" ");
        System.out.println(answer);
    }
}
