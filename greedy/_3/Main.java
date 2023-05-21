package greedy._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// *결혼식
/**
 * class(시간, '오는 시간' or '가는 시간')
 * 1. 시간을 오름차순 순서로 정렬하고 시간이 같으면 가는 시간을 앞으로 오도록 정렬한다.
 * 2. 순차적으로 탐색한다. '오는 시간'이면 count+1, '가는 시간'이면 count-1 한다.
 */
public class Main {
    static class Node {
        int time;
        char exist;
        public Node(int time, char exist) {
            this.time = time;
            this.exist = exist;
        }

        @Override
        public String toString() {
            return String.format("(time: %d, exist: %c)\n", time, exist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            list.add(new Node(s, 's'));
            list.add(new Node(e, 'e'));
        }


        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.time == o2.time) {
                    if(o1.exist == 'e') return -1;
                    return 1;
                }

                return o1.time - o2.time;
            }
        });

        int count = 0;
        int answer = 0;
        for(Node node : list) {
            if(node.exist == 's') {
                count++;
                answer = Math.max(answer, count);
            }
            else count--;
        }

        System.out.println(answer);
    }
}
