package two_pointers._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 두 배열 합치기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        for(int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(input1[i]);
        }
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(input2[i]);
        }

        int p1 = 0;
        int p2 = 0;
        StringBuilder answer = new StringBuilder();
        while(true) {
            if(p1 >= N) {
                for(int i=p2; i<M; i++) {
                    answer.append(arr2[i]).append(" ");
                }
                break;
            }
            else if(p2 >= M) {
                for(int i=p1; i<N; i++) {
                    answer.append(arr1[i]).append(" ");
                }
                break;
            }

            if(arr1[p1] > arr2[p2]) {
                answer.append(arr2[p2]).append(" ");
                p2++;
            }
            else if(arr1[p1] < arr2[p2]) {
                answer.append(arr1[p1]).append(" ");
                p1++;
            }
            else { // ==
                answer.append(arr1[p1]).append(" ").append(arr2[p2]).append(" ");
                p1++;
                p2++;
            }
        }
        System.out.println(answer);
    }
}
