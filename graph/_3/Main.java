package graph._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 송아지 찾기 1(BFS)
public class Main {
    static boolean[] visited = new boolean[10001];

    static class Person {
        int x;
        int dis;

        Person(int x, int dis) { // x: 현재 위치, dis: 이동한 거리
            this.x = x;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(S, 0)); // 현재 현수의 위치에서부터 시작

        while(!queue.isEmpty()) {
            Person p = queue.poll();
            if(visited[p.x]) continue;
            visited[p.x] = true;

            if(p.x == E) {
                System.out.println(p.dis);
                break;
            }

            if(p.x+5 <= 10001) queue.offer(new Person(p.x+5, p.dis+1)); // 앞으로 +5
            if(p.x+1 <= 10001) queue.offer(new Person(p.x+1, p.dis+1)); // 앞으로 +1
            if(p.x-1 > 0) queue.offer(new Person(p.x-1, p.dis+1)); // 뒤로 +1
        }
    }
}
