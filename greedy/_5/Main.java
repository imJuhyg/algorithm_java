package greedy._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// 결혼식(PriorityQueue 활용)
/**
 * 0~72까지의 시간순서로 이루어진 배열(type: PriorityQueue)을 만든다.
 * 동시에 존재하는 최대인원을 구하기 위해서는 가는시간을 먼저 배치해야한다. -> PriorityQueue의 정렬기준: 내림차순
 * 시간을 인덱스로 하여 오는시간은 'a', 가는시간은 'b'로 offer한다.
 * 배열을 순차적으로 탐색하면서 값이 'a'면 count+1, 'b'면 count-1 하면서 count의 최대값을 구한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Character>[] arr = new PriorityQueue[73];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int t1 = Integer.parseInt(input[0]);
            int t2 = Integer.parseInt(input[1]);
            arr[t1].offer('a');
            arr[t2].offer('b');
        }

        int answer = 0;
        int count = 0;
        for(PriorityQueue<Character> pQueue : arr) {
            while(!pQueue.isEmpty()) {
                if(pQueue.poll() == 'a') {
                    count++;
                    answer = Math.max(answer, count);
                } else {
                    count--;
                }
            }
        }
        System.out.println(answer);
    }
}