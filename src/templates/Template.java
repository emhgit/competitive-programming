package src.templates;

import java.io.*;
import java.util.*;

public class Template {
    public static void main(String[] args) throws IOException {

        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/problemname.in"));
            out = new PrintWriter(new FileWriter("src/output/problemname.out"));
        } else {
            br = new BufferedReader(new FileReader("problemname.in"));
            out = new PrintWriter(new FileWriter("problemname.out"));
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