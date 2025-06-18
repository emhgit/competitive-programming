package templates;

import java.io.*;
import java.util.*;

public class Template {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;

        // Example: Read an integer
        int n = Integer.parseInt(br.readLine());

        // Example: Read a line of integers
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }
        
        out.flush();
        out.close();
    }
}