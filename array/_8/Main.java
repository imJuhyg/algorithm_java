package array._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *등수구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] ranking = new int[N];

        for(int i=0; i<input.length; i++) {
            int rank = 1; // 자기자신을 1등으로 보고
            for(int j=0; j<input.length; j++) {
                if(Integer.parseInt(input[i]) < Integer.parseInt(input[j])) rank++; // 자기자신보다 큰 점수를 만나면 rank를 증가시킨다.
            }
            ranking[i] = rank;
        }

        StringBuilder answer = new StringBuilder();
        for(int i : ranking) {
            answer.append(i).append(" ");
        }
        System.out.println(answer);
    }
}
