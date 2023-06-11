package graph._1;

import java.util.*;

// 게임 맵 최단거리(BFS)
class Solution {
    int[] dx = {1, -1, 0, 0}; // 동 서 남 북
    int[] dy = {0, 0, 1, -1};

    class Node {
        int x, y, distance;
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[maps.length-1].length;
        int dest_x = m-1;
        int dest_y = n-1;

        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.x == dest_x && node.y == dest_y) {
                return node.distance;
            }

            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if(maps[ny][nx] == 1) {
                        if(visited[ny][nx]) continue;
                        visited[ny][nx] = true;
                        queue.offer(new Node(nx, ny, node.distance+1));
                    }
                }
            }
        }

        return -1;
    }
}