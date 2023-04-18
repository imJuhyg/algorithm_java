package stack_queue._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// **응급실
public class Main {
    static class Person {
        private int id;
        private int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        Queue<Person> queue = new LinkedList<>();
        int id = 0;
        for(String priority : input2) {
            queue.offer(new Person(id, Integer.parseInt(priority)));
            id++;
        }

        int count = 1;
        while(true) {
            Person temp = queue.poll();
            boolean isPoll = true;
            for(Person p : queue) {
                if(temp.priority < p.priority) { // 자기 자신보다 우선 순위가 더 높은 사람이 있다면 뒤로 간다.
                    queue.offer(temp);
                    isPoll = false;
                    break;
                }
            }

            if(isPoll) {
                if(temp.id == M) {
                    System.out.println(count);
                    break;
                }
                count++;
            }
        }
    }
}
