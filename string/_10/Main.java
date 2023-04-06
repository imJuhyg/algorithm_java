package string._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 가장 짧은 문자거리
public class Main {
    public String solution(String s, char t) {
        // 자기 자신 문자와 양 옆의 문자를 하나씩 비교한다.
        // 옆으로 옮겨갈 수 록 count(거리)를 1씩 증가시킨다.
        // 찾으면 다음 문자로 간다.
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            int leftCount = 0;
            int rightCount = 0;
            int left = i;
            int right = i;

            // 자기자신 비교
            if(s.charAt(i) == t) {
                sb.append(0).append(" ");
                continue;
            }

            // 양 옆으로 찾을 때까지 이동
            boolean flagA = false;
            boolean flagB = false;
            while(left-1 >= 0) {
                leftCount++;
                if(s.charAt(--left) == t) {
                    flagA = true;
                    break;
                }
            }

            while(right+1 < s.length()) {
                rightCount++;
                if (s.charAt(++right) == t) {
                    flagB = true;
                    break;
                }
            }
            if(flagA && flagB) { // 양 쪽 다 찾았을 경우
                sb.append(Math.min(leftCount, rightCount)).append(" ");
            } else if(flagA) {
                sb.append(leftCount).append(" ");
            } else {
                sb.append(rightCount).append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String answer = main.solution(input[0], input[1].charAt(0));
        System.out.println(answer);
    }
}
