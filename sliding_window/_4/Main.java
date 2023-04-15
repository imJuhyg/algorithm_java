package sliding_window._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// **최대 길이 연속부분수열
public class Main {
    // window size를 늘리면서
    // 연속된 1을 세는데, 0이 나와도 K개 만큼은 무시할 수 있다.
    // 단, k개를 모두 무시한 경우 K가 다시 0보다 클때까지 start를 늘린다.

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

        int start = 0;
        int answer = 0;
        int count = 0;
        for(int end=0; end<N; end++) {
            if(arr[end] == 1) {
                count++;
                answer = Math.max(answer, count);
            }
            else if(arr[end] == 0) {
                if(K > 0) {
                    count++;
                    answer = Math.max(answer, count);
                    K--;
                }
                else {
                    count++;
                    while(K <= 0) {
                        if(start >= N) break;

                        if(arr[start] == 1) {
                            count--;
                        }
                        else if(arr[start] == 0) {
                            count--;
                            K++;
                        }
                        start++;
                    }
                    answer = Math.max(answer, count);
                    K--;
                }
            }
        }
        System.out.println(answer);
    }
}
