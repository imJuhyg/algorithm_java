package graph._1;

import java.util.*;

// *[Programmers]게임 맵 최단거리
// 1. 동서남북으로 갈 수 있는 곳을 큐에 넣는다.
// 2. 큐에 있는 좌표를 하나씩 빼면서 이동한다.
// 3. 이동한 거리를 계산한다. (이전 노드의 이동거리+1)
// 4. 1로 되돌아 간다
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    class Node {
        int row;
        int col;
        int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int solution(int[][] maps) {
        int endRow = maps.length-1;
        int endCol = maps[0].length-1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.row == endRow && node.col == endCol) {
                return node.distance;
            }

            for(int i=0; i<4; i++) {
                int nx = node.col + dx[i];
                int ny = node.row + dy[i];

                if(nx >= 0 && nx < maps[0].length && ny >= 0 && ny < maps.length) {
                    if(visited[ny][nx]) continue;
                    if(maps[ny][nx] == 1) {
                        queue.add(new Node(ny, nx, node.distance+1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return -1;
    }
}