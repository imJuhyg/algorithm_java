package string._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자 찾기
public class Main {
    public int solution(String str, char c) {
        String s = str.toLowerCase();
        char[] arr = s.toCharArray();
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == c) count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char c = br.readLine().toLowerCase().charAt(0);

        int answer = main.solution(input, c);
        System.out.println(answer);
    }
}