package stack_queue._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 크레인 인형뽑기(카카오)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[j+1][i] = Integer.parseInt(input[j]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i=0; i<M; i++) {
            int index = Integer.parseInt(input[i]);
            int j = 0;
            while(true) {
                if(j == N) break;
                else if(arr[index][j] != 0) {
                    if(!stack.isEmpty() && stack.peek() == arr[index][j]) {
                        stack.pop();
                        answer+=2;
                        arr[index][j] = 0;
                    } else {
                        stack.push(arr[index][j]);
                        arr[index][j] = 0;
                    }
                    break;
                }
                else j++;
            }
        }
        System.out.println(answer);
    }
}
