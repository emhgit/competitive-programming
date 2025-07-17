package solutions.usacoguide.Bronze;

import java.io.*;
import java.util.*;

public class ShellGame {
    //Problem URL: https://usaco.org/index.php?page=viewproblem2&cpid=891
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new FileWriter("shell.out"));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int[] g = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
        }
        int answer = calculate(n, a, b, g);
        out.println(answer);

        br.close();
        out.flush();
        out.close();
    }

    public static int calculate(int n, int[] a, int[] b, int[] g){
        int[] correct = new int[3];
        for(int i = 0; i < 3; i++){
            int curr = i + 1;
            for(int j = 0; j < n; j++){
                if(a[j] == curr){
                    curr = b[j];
                } else if(b[j] == curr){
                    curr = a[j];
                }
                if (g[j] == curr) correct[i]++;
            }
        }
        return Math.max(correct[0], Math.max(correct[1], correct[2]));
    }
}
