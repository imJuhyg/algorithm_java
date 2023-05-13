package graph._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Dijkstra 알고리즘
 * 1. 아직 방문하지 않은 거리를 모두 무한으로 초기화한다.
 * 2. 출발지 노드의 거리를 0으로 하고 갈수있는 다음 노드까지의 거리를 계산하여 거리를 업데이트한다.
 *    (이미 방문한 적이 있다면 더 빨리 도착할 수 있는 거리로 업데이트한다.)
 * 3. 가장 이동거리가 짧은 노드부터 방문한다.(Priority Queue 사용)
 * 4. 2-3 반복
 */

// **최단거리(Dijkstra) - 1753
public class Main {
    static class Node implements Comparable<Node> {
        int v; // 갈수있는 노드번호
        int w; // 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return String.format("(v: %d, w: %d)", v, w);
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int V = Integer.parseInt(input1[0]);
        int E = Integer.parseInt(input1[1]);
        int K = Integer.parseInt(br.readLine());

        dis = new int[V+1];
        Arrays.fill(dis, Integer.MAX_VALUE);                                // 방문하지 않은 노드들을 무한에 가까운 수로 채운다.

        // u -> v 가중치 그래프 생성
        ArrayList<Node>[] graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            graph[u].add(new Node(v, w));                                   // u -> v로 갈수있는 노드 추가
        }

        solution(graph, K, V);

        for(int i=1; i<dis.length; i++) {
            if(dis[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dis[i]);
        }
    }

    static void solution(ArrayList<Node>[] graph, int K, int V) {
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));                                       // 출발지 노드
        dis[K] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(visited[node.v]) continue;
            visited[node.v] = true;

            for(Node next : graph[node.v]) {
                /**
                 * 최단거리 업데이트
                 * dis[next.v]:    출발지로부터 방문할 노드까지의 거리
                 * = dis[node.v]:  출발지로부터 현재 노드까지의 거리
                 * + next.w:       현재 노드에서 다음 노드까지의 거리
                 */
                if(dis[next.v] > dis[node.v] + next.w) {
                    dis[next.v] = dis[node.v] + next.w;
                    queue.offer(new Node(next.v, dis[next.v]));
                }
            }
        }
    }
}
