import java.io.*;
import java.util.*;

public class ShellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new FileWriter("mixmilk.out"));
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
