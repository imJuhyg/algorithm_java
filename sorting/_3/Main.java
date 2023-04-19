package sorting._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 삽입 정렬
 * 1. 배열의 원소 중 하나를 기준으로 잡는다.
 * 2. 해당 배열의 이전 원소들 부터 차례대로 비교한다.
 * 3. 정렬 조건이 일치하면 원래 위치에 있던 원소를 한 칸 뒤로 이동하고 기준 원소를 빈 자리에 삽입한다.
 * 4. 정렬 조건이 일치하지 않으면 다음 원소를 기준으로 잡고 1번으로 되돌아간다.
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
        int pivot = 1;
        while(pivot < N) {
            for(int i=pivot; i>0; i--) {
                if(arr[i] < arr[i-1]) {
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
                else break;
            }
            pivot++;
        }

        StringBuilder answer = new StringBuilder();
        for(int i : arr) answer.append(i).append(" ");
        System.out.println(answer);
    }
}
