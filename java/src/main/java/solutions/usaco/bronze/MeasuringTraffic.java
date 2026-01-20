package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class MeasuringTraffic {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("java/src/input/traffic.in"));
            out = new PrintWriter(new FileWriter("java/src/output/traffic.out"));
        } else {
            br = new BufferedReader(new FileReader("traffic.in"));
            out = new PrintWriter(new FileWriter("traffic.out"));
        }

        StringTokenizer st;

        // Example: Read an integer
        int n = Integer.parseInt(br.readLine());

        // Example: Read a line of integers
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        out.flush();
        out.close();
    }
}