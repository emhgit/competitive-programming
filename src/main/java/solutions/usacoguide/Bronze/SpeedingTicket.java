package solutions.usacoguide.Bronze;

import java.io.*;
import java.util.*;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {

        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/speeding.in"));
            out = new PrintWriter(new FileWriter("src/output/speeding.out"));
        } else {
            br = new BufferedReader(new FileReader("speeding.in"));
            out = new PrintWriter(new FileWriter("speeding.out"));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int pos = 0;

        int[] road = new int[100];
        int[] bessie = new int[100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            for (int j = pos; j < pos + length; j++) {
                road[j] = limit;
            }
            pos += length;
        }

        pos = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = pos; j < pos + length; j++) {
                bessie[j] = speed;
            }
            pos += length;
        }

        int maxOver = 0;
        for (int i = 0; i < 100; i++) {
            maxOver = Math.max(maxOver, bessie[i] - road[i]);
        }
        out.println(maxOver);

        br.close();
        out.flush();
        out.close();
    }
}