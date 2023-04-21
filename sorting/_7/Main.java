package sorting._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// ***[BOJ]힙 정렬(2220)
// 힙을 삽입하면서 1을 가장 마지막에 위치시키면 스왑 횟수가 최대가 되는 힙을 만들 수 있다.
public class Main {
    static class MaxHeap {
        public ArrayList<Integer> list;
        private int index_1 = 0; // 1. 값이 1인 노드의 위치를 저장한다.
        private int swap_index = 0; // (새로 들어온 노드가 1과 스왑되어 그 위치에서 heapify하기 위해 swap된 Index 저장)

        public MaxHeap() {
            list = new ArrayList<>();
        }

        void add(int item) {
            list.add(item);

            // 2. heapify를 수행하기 전에 1의 위치와 마지막 노드(추가하는 노드)의 위치를 변경한다.
            swap(index_1, list.size()-1);

            // 3. 1과 스왑된 인덱스에서부터 heapify를 수행한다.
            int child = swap_index;
            while((child-1)/2 >= 0) {
                int parent = (child-1)/2;
                if(list.get(child) <= list.get(parent)) break;

                swap(parent, child);

                child = parent;
            }
        }

        void swap(int i1, int i2) {
            int temp = list.get(i2);
            list.set(i2, list.get(i1));
            list.set(i1, temp);

            if(list.get(i1) == 1) {
                index_1 = i1;               // swap한 노드가 1이면 인덱스 저장
                swap_index = i2;            // swap된 노드 인덱스 저장
            }
            else if(list.get(i2) == 1) {
                index_1 = i2;
                swap_index = i1;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MaxHeap heap = new MaxHeap();
        for(int i=1; i<=n; i++) {
            heap.add(i);
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0; i< heap.list.size(); i++) {
            answer.append(heap.list.get(i)).append(" ");
        }
        System.out.println(answer);
    }
}