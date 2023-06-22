package union_find._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

// ** 거짓말(1043)
public class Main {
    static class UnionFind {
        ArrayList<Integer> list;
        public UnionFind(int n) {
            list = new ArrayList<>();
            makeSet(n);
        }

        public void makeSet(int n) {
            for(int i=0; i<=n; i++) {
                list.add(i);
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
        int N = Integer.parseInt(input[0]); // 사람 수
        int M = Integer.parseInt(input[1]); // 파티 수

        String[] input2 = br.readLine().split(" ");
        int knows_len = Integer.parseInt(input2[0]);
        boolean[] knows = new boolean[N+1]; // 진실을 아는 사람 배열
        if(knows_len > 0) {
            for(int i=1; i<=knows_len; i++) {
                knows[Integer.parseInt(input2[i])] = true;
            }
        }

        HashSet<Integer>[] parties = new HashSet[M]; // 파티 번호와 파티에 참여하는 사람 배열
        for(int i=0; i<parties.length; i++) {
            parties[i] = new HashSet<>();
        }

        UnionFind unionFind = new UnionFind(N);

        for(int i=0; i<M; i++) {
            String[] input3 = br.readLine().split(" ");
            int parties_len = Integer.parseInt(input3[0]);

            if(parties_len >= 1) {
                if(parties_len == 1) {
                    parties[i].add(Integer.parseInt(input3[1]));
                    continue;
                }
                for(int j=1; j<parties_len; j++) {
                    int node1 = Integer.parseInt(input3[j]);
                    int node2 = Integer.parseInt(input3[j+1]);

                    // 파티 참여자
                    parties[i].add(node1);
                    parties[i].add(node2);

                    // 집합 만들기
                    unionFind.union(node1, node2);
                }
            }
        }

        boolean[] visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            if(knows[i] && !visited[i]) {
                int parent = unionFind.find(i);
                for(int j=1; j<=N; j++) {
                    if(unionFind.find(j) == parent) {
                        knows[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int answer = M;
        for(HashSet<Integer> set : parties) {
            for(int node : set) {
                if(knows[node]) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
