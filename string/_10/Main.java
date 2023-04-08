package string._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *가장 짧은 문자거리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String s = input[0];
        char t = input[1].charAt(0);

        int[] answer = new int[s.length()];
        int p = 1000;

        // t를 찾으면 0으로 바꾸는 방식 - t와 멀어질 수록 1씩 증가
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == t) p=0;
            else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == t) p=0;
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        for(int num : answer) System.out.print(num + " ");
    }
}
