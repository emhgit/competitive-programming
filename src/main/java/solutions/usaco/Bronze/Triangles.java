package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class Triangles {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/triangles.in"));
            out = new PrintWriter(new FileWriter("src/output/triangles.out"));
        } else {
            br = new BufferedReader(new FileReader("triangles.in"));
            out = new PrintWriter(new FileWriter("triangles.out"));
        }
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        // read in
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        int maxArea = 0;

        // iterate for i, j, k
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int base;
                    // get the base by finding the points with the same y coord
                    if (points[i].y == points[j].y) {
                        base = Math.abs(points[i].x - points[j].x);
                    } else if (points[i].y == points[k].y) {
                        base = Math.abs(points[i].x - points[k].x);
                    } else if (points[j].y == points[k].y) {
                        base = Math.abs(points[j].x - points[k].x);
                    } else {
                        continue;
                    }

                    int height;
                    // get height by finding points with same x coord
                    if (points[i].x == points[j].x) {
                        height = Math.abs(points[i].y - points[j].y);
                    } else if (points[i].x == points[k].x) {
                        height = Math.abs(points[i].y - points[k].y);
                    } else if (points[j].x == points[k].x) {
                        height = Math.abs(points[j].y - points[k].y);
                    } else {
                        continue;
                    }

                    int area = base * height;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        out.println(maxArea);

        br.close();
        out.flush();
        out.close();
    }

    // create point class
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
