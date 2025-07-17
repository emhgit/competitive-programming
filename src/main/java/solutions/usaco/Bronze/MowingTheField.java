package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class MowingTheField {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/mowing.in"));
            out = new PrintWriter(new FileWriter("src/output/mowing.out"));
        } else {
            br = new BufferedReader(new FileReader("mowing.in"));
            out = new PrintWriter(new FileWriter("mowing.out"));
        }

        StringTokenizer st;

        boolean[][] visited = new boolean[2001][2001];
        int[][] time = new int[2001][2001];
        int x = 1000, y = 1000, X = 1001, t = 0;
        visited[x][y] = true;
        time[x][y] = t;
        t++;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int steps = Integer.parseInt(st.nextToken());
            int xDir = 0, yDir = 0;
            switch (direction) {
                case "N":
                    xDir = -1;
                    break;
                case "E":
                    yDir = 1;
                    break;
                case "S":
                    xDir = 1;
                    break;
                case "W":
                    yDir = -1;
                    break;
            }
            for (int j = 0; j < steps; j++) {
                x += xDir;
                y += yDir;
                if (visited[x][y]) {
                    X = Math.min(X, t - time[x][y]);
                    time[x][y] = t;
                } else {
                    visited[x][y] = true;
                    time[x][y] = t;
                }
                t++;
            }
        }

        out.println(X == 1001 ? -1 : X);

        br.close();
        out.flush();
        out.close();
    }
}