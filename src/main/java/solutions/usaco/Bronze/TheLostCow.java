package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class TheLostCow {
    // problem URL: https://usaco.org/index.php?page=viewproblem2&cpid=735
    public static void main(String[] args) throws IOException {

        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/lostcow.in"));
            out = new PrintWriter(new FileWriter("src/output/lostcow.out"));
        } else {
            br = new BufferedReader(new FileReader("lostcow.in"));
            out = new PrintWriter(new FileWriter("lostcow.out"));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = 1;
        int dist = 1;
        int travelled = 0;

        while (true) {
            if ((dir == 1 && x <= y && y <= (x + dist * dir)) ||
                    (dir == -1 && x >= y && y >= (x + dist * dir))) {
                out.println(travelled + Math.abs(x - y));
                break;
            } else {
                travelled += dist * 2;
                dist *= 2;
                dir *= -1;
            }
        }

        br.close();
        out.flush();
        out.close();
    }
}