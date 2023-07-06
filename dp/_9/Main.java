package dp._9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// **가장 높은 탑 쌓기(2) - (2655)
public class Main {
    static class Brick implements Comparable<Brick> {
        int num;
        int s;
        int h;
        int w;

        public Brick(int num, int s, int h, int w) {
            this.num = num;
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s;
        }

        @Override
        public String toString() {
            return String.format("(num: %d, s: %d, h: %d, w: %d)\n", num, s, h, w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Brick[] bricks = new Brick[N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            bricks[i] = new Brick(i+1, s, h, w);
        }
        Arrays.sort(bricks);

        int[][] D = new int[N][2]; // D[i][0]: bricks[i]를 가장 위에 놓았을 때의 최대 높이
                                   // D[i][1]: bricks[i] 바로 밑에 놓인 벽돌의 인덱스

        D[0][0] = bricks[0].h;
        D[0][1] = -1;

        for(int i=1; i<N; i++) {
            int max = 0;
            int belowIndex = -1; // 벽돌을 아래에 둘 수 없는 경우
            for(int j=i-1; j>=0; j--) {
                if(bricks[j].w > bricks[i].w && D[j][0] > max) {
                    max = D[j][0];
                    belowIndex = j;
                }
            }
            D[i][0] = max + bricks[i].h;
            D[i][1] = belowIndex;

        }

        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        int start = 0;
        int maxHeight = 0;
        for(int i=0; i<D.length; i++) {
            if(D[i][0] > maxHeight) {
                maxHeight = D[i][0];
                start = i;
            }
        }

        while(start > -1) {
            temp.add(bricks[start].num);
            count++;

            start = D[start][1];
        }

        System.out.println(count);
        for(int answer : temp) {
            System.out.println(answer);
        }
    }
}
