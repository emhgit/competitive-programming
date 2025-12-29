package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class GuessTheAnimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Animal[] animals = new Animal[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Set<String> characteristics = new HashSet<>();
            String name = st.nextToken();
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                characteristics.add(st.nextToken());
            }
            animals[i] = new Animal(name, size, characteristics);
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Set<String> intersection = new HashSet<>(animals[i].characteristics);
                intersection.retainAll(animals[j].characteristics);
                max = Math.max(max, intersection.size() + 1);
            }
        }
        out.println(max);
        br.close();
        out.flush();
        out.close();
    }

    static class Animal {
        String name;
        int size;
        Set<String> characteristics;

        public Animal(String name, int size, Set<String> characteristics) {
            this.name = name;
            this.size = size;
            this.characteristics = characteristics;
        }
    }
}