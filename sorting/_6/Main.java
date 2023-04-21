package sorting._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// **이분검색(Heap Sort구현) - O(nlog n) 만족
public class Main {
    static class MinHeap {
        private ArrayList<Integer> list;

        public MinHeap() {
            list = new ArrayList<>();
        }

        void add(int item) {
            list.add(item);                                         // 1. 힙의 마지막에 값을 추가한다.
            int child = list.size()-1;

            while((child-1)/2 >= 0) {                                // 2. 힙 구조를 만족시키도록 재구성한다.
                int parent = (child-1)/2;

                if(list.get(parent) <= list.get(child)) break;

                int temp = list.get(parent);
                list.set(parent, list.get(child));
                list.set(child, temp);

                child = parent;
            }
        }

        int remove() {
            int removed = list.get(0);                              // 1. 힙의 루트를 삭제한다.
            list.set(0, list.get(list.size()-1));                   // 2. 힙의 마지막 요소를 루트로 이동시킨다.
            list.remove(list.size()-1);

            int parent = 0;
            while(parent*2+1 < list.size()) {                       // 3. 힙 구조를 만족시키도록 재구성한다.
                int child = parent*2+1;

                // 자식노드가 두 개 있다면 더 작은 자식노드를 Swap 한다.
                if(child+1 < list.size() && list.get(child+1) < list.get(child)) child++;
                if(list.get(parent) <= list.get(child)) break;

                int temp = list.get(parent);
                list.set(parent, list.get(child));
                list.set(child, temp);

                parent = child;
            }

            return removed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] input2 = br.readLine().split(" ");

        MinHeap heap = new MinHeap();
        for(int i=0; i<N; i++) {
            heap.add(Integer.parseInt(input2[i]));
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            answer++;
            if(heap.remove() == M) break;
        }
        System.out.println(answer);
    }
}