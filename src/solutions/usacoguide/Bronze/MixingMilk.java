package src.solutions.usacoguide.Bronze;
import java.io.*;
import java.util.*;

public class MixingMilk {
    // Problem URL: https://usaco.org/index.php?page=viewproblem2&cpid=855#
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new FileWriter("mixmilk.out"));
        StringTokenizer st;

        int[] capacity = new int[3];
        int[] milk = new int[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            capacity[i] = Integer.parseInt(st.nextToken());
            milk[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solve(capacity, milk);
        for(int i = 0; i < 3; i++) out.println(result[i]);

        br.close();
        out.flush();
        out.close();
    }

    public static int[] solve(int[] capacity, int[] milk){
        for(int i = 0; i < 100; i++){
            int bucket1 = i % 3;
            int bucket2 = (i + 1) % 3;

            int amt = Math.min(milk[bucket1], capacity[bucket2] - milk[bucket2]);

            milk[bucket1] -= amt;
            milk[bucket2] += amt;
        }       
        return milk;
    }
}
