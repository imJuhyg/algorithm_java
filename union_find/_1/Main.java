package union_find._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 친구인가?
// https://www.notion.so/cs-docs/Union-Find-6915fe799cc34250846d09cbae992321
public class Main {
    static class UnionFind {
        ArrayList<Integer> list;
        public UnionFind(int n) {
            list = new ArrayList<>();
            makeSet(n);
        }

        public void makeSet(int n) {
            for(int i=0; i<=n; i++) {
                list.add(i); // Union-Find 의 초기상태
            }
        }

        public int find(int node) {
            if(list.get(node) == node) return node;
            return find(list.get(node));
        }

        public void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if(parent1 != parent2) list.set(parent2, parent1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        UnionFind unionFind = new UnionFind(N);
        for(int i=0; i<M; i++) {
            String[] input2 = br.readLine().split(" ");
            int node1 = Integer.parseInt(input2[0]);
            int node2 = Integer.parseInt(input2[1]);

            unionFind.union(node1, node2);
        }
        String[] input3 = br.readLine().split(" ");
        int a = Integer.parseInt(input3[0]);
        int b = Integer.parseInt(input3[1]);

        if(unionFind.find(a) == unionFind.find(b)) System.out.println("YES"); // 부모노드가 같으면 같은 집합이다.
        else System.out.println("NO");
    }
}
