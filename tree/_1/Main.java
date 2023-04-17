package tree._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

// *K번째 큰 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += arr[i];
            for(int j=i+1; j<N; j++) {
                sum += arr[j];
                for(int k=j+1; k<N; k++) {
                    sum += arr[k];
                    set.add(sum);
                    sum -= arr[k];
                }
                sum -= arr[j];
            }
            sum -= arr[i];
        }
        LinkedList<Integer> list = new LinkedList<>(set);
        if(list.size() < K-1) System.out.println(-1);
        else System.out.println(list.get(K-1));
    }
}
