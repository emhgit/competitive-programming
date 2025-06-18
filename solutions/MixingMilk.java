package solutions;

import java.io.*;
import java.util.*;

public class MixingMilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;

        int[][] buckets = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            buckets[i][0] = Integer.parseInt(st.nextToken());
            buckets[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] milk = solve(buckets);
        for(int i = 0; i < 3; i++) out.println(milk[i]);

        out.flush();
        out.close();
    }

    public static int[] solve(int[][] buckets){
        int[] milk = new int[3];
        for(int i = 0; i < 100; i++){
            
        }       
        return milk;
    }
}
