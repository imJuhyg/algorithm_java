package union_find._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// *사이클 게임(20040)
public class Main {
    static class UnionFind {
        ArrayList<Integer> list;
        public UnionFind(int n) {
            list = new ArrayList<>();
            makeSet(n);
        }

        void makeSet(int n) {
            for(int i=0; i<n; i++) {
                list.add(i);
            }
        }

        int find(int node) {
            if(list.get(node) == node) return node;
            return find(list.get(node));
        }

        void union(int node1, int node2) {
            int p1 = find(node1);
            int p2 = find(node2);
            if(p1 != p2) list.set(p2, p1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        UnionFind unionFind = new UnionFind(n);
        boolean answer = false;
        int count = 0;
        for(int i=0; i<m; i++) {
            count++;

            // 사이클이 생성되는 경우 = 이미 같은 집합에 대해 또 연결하는 경우
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            if(unionFind.find(a) != unionFind.find(b)) {
                unionFind.union(a, b);
            }
            else {
                answer = true;
                System.out.println(count);
                break;
            }
        }
        if(!answer) System.out.println(0);
    }
}
