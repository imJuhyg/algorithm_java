package sorting._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 선택 정렬
 * 1. 배열에서 최대/최소를 찾는다.
 * 2. 배열의 맨 앞 원소와 위치를 교환한다.
 * 3. 선택되어 자리를 찾은 원소를 제외하고 다시 1번으로 돌아간다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Sorting
        for(int i=0; i<N; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int j=i; j<N; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }

            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

        StringBuilder answer = new StringBuilder();
        for(int num : arr) {
            answer.append(num).append(" ");
        }
        System.out.println(answer);
    }
}
