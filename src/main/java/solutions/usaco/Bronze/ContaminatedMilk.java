package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class ContaminatedMilk {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/badmilk.in"));
            out = new PrintWriter(new FileWriter("src/output/badmilk.out"));
        } else {
            br = new BufferedReader(new FileReader("badmilk.in"));
            out = new PrintWriter(new FileWriter("badmilk.out"));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Integer.parseInt(st.nextToken()); // M
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        Person[] people = new Person[N + 1];
        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());
            int milkType = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if (people[person] == null) {
                Person p = new Person();
                p.history[time] = milkType + " ";
                people[person] = p;
            } else {
                people[person].history[time] = people[person].history[time] == null ? milkType + " "
                        : people[person].history[time] + milkType + " ";
            }
        }

        Set<Integer> possibleMilkTypes = new HashSet<>();
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if (i == 0) {
                for (int j = time - 1; j >= 1; j--) {
                    if (people[person].history[j] == null)
                        continue;
                    st = new StringTokenizer(people[person].history[j]);

                    while (st.hasMoreTokens()) {
                        int possibleMilkType = Integer.parseInt(st.nextToken());
                        possibleMilkTypes.add(possibleMilkType);
                    }
                }
            } else {
                Set<Integer> currSet = new HashSet<>();
                for (int j = time - 1; j >= 1; j--) {
                    if (people[person].history[j] == null)
                        continue;
                    st = new StringTokenizer(people[person].history[j]);
                    while (st.hasMoreTokens()) {
                        int possibleMilkType = Integer.parseInt(st.nextToken());
                        currSet.add(possibleMilkType);
                    }
                }
                possibleMilkTypes.retainAll(currSet);
            }
        }

        int max = 0;
        for (int milkType : possibleMilkTypes) {
            int currMax = 0;
            for (int i = 1; i <= N; i++) {
                if (people[i] == null)
                    continue;
                for (int j = 1; j <= 100; j++) {
                    if (people[i].history[j] == null)
                        continue;
                    st = new StringTokenizer(people[i].history[j]);
                    boolean found = false;
                    while (st.hasMoreTokens()) {
                        if (Integer.parseInt(st.nextToken()) == milkType) {
                            currMax++;
                            found = true;
                            break;
                        }

                    }
                    if (found)
                        break;
                }
            }
            max = Math.max(max, currMax);
        }
        out.println(max);

        br.close();
        out.flush();
        out.close();
    }

    static class Person {
        String[] history;

        public Person() {
            history = new String[101];
        }
    }
}
