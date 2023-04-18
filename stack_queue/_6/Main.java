package stack_queue._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 공주 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }
        int count = 1;
        while(true) {
            if(count == K) {
                count = 1;
                queue.poll();
                continue;
            }

            if(queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }

            queue.add(queue.poll());
            count++;
        }
    }
}
