package binary_saerch._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// *이분검색(Binary-search)
// 정렬된 배열에서 특정 값을 찾고자 할 때 중앙값을 이용하여 탐색하는 알고리즘
// 순차적 탐색 방법보다 시간 효율성이 더 높다. O(n) => O(log n)
// 1. 정렬된 배열에서 중앙값(lt+rt)/2 = mid 를 확인한다.
// 2. 중앙값이 찾고자하는 값보다 클 경우 mid+1 = lt, (lt+rt)/2 = mid 범위로 좁힌다.
// 2-1. 중앙값이 찾고자하는 값보다 작을 경우 mid-1 = rt, (lt+rt)/2 = mid 범위로 좁힌다.
// 3. 중앙값이 찾고자하는 값일 때까지 반복한다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        // 정렬된 배열 만들기
        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length-1;
        int answer = 0;
        while(lt <= rt) {
            int mid = (lt+rt)/2;
            if(M > arr[mid]) lt = mid+1;
            else if(M < arr[mid]) rt = mid-1;
            else {
                answer = mid+1;
                break;
            }
        }
        System.out.println(answer);
    }
}
