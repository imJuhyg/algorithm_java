package sorting._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// **이분검색(Heap Sort구현) - O(nlog n) 만족
public class Main {
    static class MinHeap {
        private int[] arr;

        public MinHeap() {
            arr = new int[0];

        }

        void add(int item) {
            // 배열 확장
            int[] tempArray = new int[arr.length+1];
            for(int i=0; i<arr.length; i++) {
                tempArray[i] = arr[i];
            }
            tempArray[tempArray.length-1] = item;           // 1. 확장된 배열 마지막에 값 추가
            arr = tempArray;

            // heapify
            for(int i=arr.length-1; i>0; i--) {             // 2. 말단부터 heapify
                int child = i;

                while(child > 0) {
                    int parent = (child-1)/2;

                    if(arr[child] > arr[parent]) break;

                    int temp = arr[parent];
                    arr[parent] = arr[child];
                    arr[child] = temp;

                    child = parent;
                }
            }
        }

        int remove() {
            if(arr.length == 1) return arr[0];

            int removed = arr[0];                           // 1. 루트노드를 꺼낸다.
            int last = arr[arr.length-1];

            // 배열 축소
            int[] tempArray = new int[arr.length-1];
            tempArray[0] = last;                            // 2. 마지막 요소를 루트로 이동시킨다.
            for(int i=1; i<tempArray.length; i++) {
                tempArray[i] = arr[i];
            }
            arr = tempArray;

            // heapify
            for(int i=0; i<arr.length-1; i++) {             // 3. 루트부터 heapify
                int parent = i;

                while(parent*2+1 < arr.length) {
                    int child = parent*2+1;

                    // 자식 노드가 두 개인 경우 값이 더 작은 노드를 swap 해야한다.
                    if(child+1 < arr.length && arr[child+1] < arr[child]) child++;
                    if(arr[parent] < arr[child]) break;

                    int temp = arr[child];
                    arr[child] = arr[parent];
                    arr[parent] = temp;

                    parent = child;
                }
            }
            return removed;
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
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