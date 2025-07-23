package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/gymnastics.in"));
            out = new PrintWriter(new FileWriter("src/output/gymnastics.out"));
        } else {
            br = new BufferedReader(new FileReader("gymnastics.in"));
            out = new PrintWriter(new FileWriter("gymnastics.out"));
        }

        br.close();
        out.flush();
        out.close();
    }
}