package dp._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 가장 높은 탑 쌓기(1)
public class Main {
    static class Brick implements Comparable<Brick>{
        int s; // 밑면
        int h; // 높이
        int w; // 무게

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            /**
             * 밑면을 내림차순으로 정렬하면 무게만 비교할 수 있다.
             */
            return o.s-this.s;
        }

        @Override
        public String toString() {
            return String.format("(s: %d, h: %d, w: %d)", s, h, w);
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
            bricks[i] = new Brick(s, h, w);
        }
        Arrays.sort(bricks);
        int[] D = new int[N]; // i번 벽돌을 가장 위에 놓았을 때의 최대무게
        // 맨 밑 벽돌
        D[0] = bricks[0].h;

        int answer = 0;
        for(int i=1; i<N; i++) {
            int max = 0;
            for(int j=i-1; j>=0; j--) {
                if(bricks[j].w > bricks[i].w && D[j] > max) {
                    max = D[j];
                }
            }
            D[i] = max + bricks[i].h; // i번 벽돌 바로 밑에 쌓을 수 있는 벽돌의 무게
            answer = Math.max(answer, D[i]);
        }

        System.out.println(answer);
    }
}
