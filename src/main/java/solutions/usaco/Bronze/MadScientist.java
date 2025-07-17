package solutions.usacoguide.Bronze;

import java.io.*;

public class MadScientist {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/breedflip.in"));
            out = new PrintWriter(new FileWriter("src/output/breedflip.out"));
        } else {
            br = new BufferedReader(new FileReader("breedflip.in"));
            out = new PrintWriter(new FileWriter("breedflip.out"));
        }

        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                min++;
                while (i < n && a.charAt(i) != b.charAt(i)) {
                    i++;
                }
            }
        }
        out.println(min);

        br.close();
        out.flush();
        out.close();
    }
}