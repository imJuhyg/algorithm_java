import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// *동전교환(DFS)
public class Main {
    static int min = Integer.MAX_VALUE;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        M = Integer.parseInt(br.readLine());
        Arrays.sort(arr, Collections.reverseOrder());
        DFS(arr, 0, 0);
        System.out.println(min);
    }

    static void DFS(Integer[] arr, int count, int sum) {
        if(count > min) return;
        if(sum == M) {
            min = Math.min(min, count);
            return;
        }
        for(int i=0; i<arr.length; i++) {
            if(sum + arr[i] <= M) DFS(arr, count+1, sum + arr[i]);
        }
    }
}
