package array._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 점수계산
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");

        int sum = 0;
        int pre = 0; // 누산기
        for(int i=0; i<N; i++) {
            if(Integer.parseInt(scores[i]) == 1) { // 맞으면
                pre += 1;
                sum += pre;
            }
            else { // 틀리면
                pre = 0;
            }
        }

        System.out.println(sum);
    }
}
