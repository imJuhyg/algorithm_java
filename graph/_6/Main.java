package graph._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 최소비용 구하기(Dijkstra) - 1916
public class Main {
    static class Node implements Comparable<Node>{
        int n;          // 도착지 노드 번호
        int weight;     // 도착지까지의 비용

        public Node(int n, int weight) {
            this.n = n;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", n, weight);
        }
    }

    static ArrayList<Node>[] nodes;
    static int sNode;   // 출발지 노드
    static int dNode;   // 도착지 노드
    static int[] dis;   // 각 노드별 최단거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int source = Integer.parseInt(input[0]);
            int dest = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            nodes[source].add(new Node(dest, weight)); // source -> dest (비용: weight)
        }

        String[] input = br.readLine().split(" ");
        sNode = Integer.parseInt(input[0]);
        dNode = Integer.parseInt(input[1]);

        dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dijkstra(N);
        System.out.println(dis[dNode]);
    }

    static void dijkstra(int N) {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(sNode, 0));
        dis[sNode] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(visited[node.n]) continue;
            visited[node.n] = true;

            for(Node next : nodes[node.n]) {
                if(dis[next.n] > next.weight + dis[node.n]) {
                    dis[next.n] = next.weight + dis[node.n];
                    queue.offer(new Node(next.n, dis[next.n]));
                }
            }
        }
    }
}
