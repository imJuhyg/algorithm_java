package string._12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *암호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringBuilder answer = new StringBuilder();
        int start = 0;
        int end = 7;

        for(int i=0; i<N; i++) {
            String str = input.substring(start, end);
            StringBuilder binaryString = new StringBuilder();
           for(int j=0; j<7; j++) {
               if(str.charAt(j) == '#') binaryString.append('1');
               else if(str.charAt(j) == '*') binaryString.append('0');
           }
           int decimal = Integer.parseInt(binaryString.toString(), 2);
            answer.append((char)decimal);

            start = end;
            end = end+7;
        }

        System.out.println(answer);
    }
}
