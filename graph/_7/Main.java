package graph._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ** 특정한 최단 경로(1504)
public class Main {
    static class Node implements Comparable<Node>{
        int go;
        int weight;

        public Node(int go, int weight) {
            this.go = go;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }

        @Override
        public String toString() {
            return String.format("(go: %d, weight: %d)\n", go, weight);
        }
    }

    static int N;
    static int INF = 200000*1000;
    static ArrayList<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        nodes = new ArrayList[N+1];
        for(int i=0; i< nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);
            // non-direction
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }
        String[] input3 = br.readLine().split(" ");
        int v1 = Integer.parseInt(input3[0]);
        int v2 = Integer.parseInt(input3[1]);

        // 1 -> v1 -> v2 -> N 까지의 거리 구하기
        // 1 -> v2 -> v1 -> N 까지의 거리 구하기
        // 둘 중 더 작은 경로를 정답으로 한다.
        int answer1 = 0;
        int answer2 = 0;

        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, N);

        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, N);


        int answer = Math.min(answer1, answer2);
        if(answer >= INF) answer = -1;

        System.out.println(answer);
    }


    // start 노드부터 end 노드까지의 최단 거리를 구하는 함수
    public static int dijkstra(int start, int end) {
        int[] d = new int[N+1];
        Arrays.fill(d, INF);
        d[start] = 0;

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.offer(new Node(start, d[start]));

        while(!pQueue.isEmpty()) {
            Node node = pQueue.poll();
            if(visited[node.go]) continue;
            visited[node.go] = true;

            for(Node next : nodes[node.go]) {
                if(d[next.go] > d[node.go] + next.weight) {
                    d[next.go] = d[node.go] + next.weight;
                    pQueue.offer(new Node(next.go, d[next.go]));
                }
            }
        }

        return d[end];
    }
}
