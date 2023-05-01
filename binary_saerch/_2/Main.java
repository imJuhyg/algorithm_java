package binary_saerch._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// **뮤직비디오
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int _max = 0;
        int _sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > _max) _max = arr[i];
            _sum += arr[i];
        }
        int lt = _max;
        int rt = _sum;
        int answer = 0;


        while(lt <= rt) {
            int mid = (lt+rt)/2;        // DVD 용량
            int sum = 0;                // 하나의 DVD에 담은 노래의 총 용량
            int count = 0;              // DVD 갯수
            // DVD에 정해진 용량만큼 담아보기
            for(int i=0; i<N; i++) {
                sum += arr[i];
                if(sum > mid) {
                    count++;
                    sum = 0;
                    i = i-1;            // 되돌아가기

                } else if(i==N-1) {
                    count++;
                }
            }

            if(count <= M) {            // DVD 갯수가 M미만이면 범위를 좁힌다.
                answer = mid;
                rt = mid-1;
            }
            else {                      // 용량이 더 필요한 경우
                lt = mid+1;
            }
        }
        System.out.println(answer);
    }
}