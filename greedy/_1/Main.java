package greedy._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 씨름 선수(Greedy)
public class Main {
    static class Person  {
        int h;
        int w;
        public Person(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public String toString() {
            return String.format("(h: %d, w: %d)\n", h, w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person[] pArray = new Person[N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            pArray[i] = new Person(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        // 1. 키 내림차순 순서로 정렬한다.
        Arrays.sort(pArray, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.h -p1.h;
            }
        });

        int answer = 1;
        // 2. 나보다 키가 큰 사람들 중에서 몸무게는 내가 가장 클 때 선발된다.
        // (키가 가장 큰 사람은 자신보다 키 큰 사람이 없기 때문에 무조건 선발된다.)
        int max = pArray[0].w;
        for(int i=1; i<pArray.length; i++) {
            if(max <= pArray[i].w) {
                answer++;
                max = pArray[i].w;
            }
        }

        // System.out.println(Arrays.toString(pArray));
        System.out.println(answer);
    }
}
