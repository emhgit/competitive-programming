package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("java/src/input/cownomics.in"));
            out = new PrintWriter(new FileWriter("java/src/output/cownomics.out"));
        } else {
            br = new BufferedReader(new FileReader("cownomics.in"));
            out = new PrintWriter(new FileWriter("cownomics.out"));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // spotty cows must have genome all plain cows dont have, vice versa
        // iterate n times
        // if spotty[i][j] != plain[i][j] and spottyGenomeSet doesnt contain plain[i][j]
        String[] spottyGenomes = new String[N];
        String[] plainGenomes = new String[N];
        Set<Character> spottySet;
        // read in spotty cows
        for (int i = 0; i < N; i++) {
            spottyGenomes[i] = br.readLine();
        }

        // read in plain cows
        for (int i = 0; i < N; i++) {
            plainGenomes[i] = br.readLine();
        }

        int validLocations = 0;
        for (int i = 0; i < M; i++) {
            spottySet = new HashSet<>();
            boolean valid = true;
            for (int j = 0; j < N; j++) {
                char spottyGenome = spottyGenomes[j].charAt(i);
                spottySet.add(spottyGenome);
            }
            for (int j = 0; j < N; j++) {
                char plainGenome = plainGenomes[j].charAt(i);
                if (spottySet.contains(plainGenome)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                validLocations++;
            }
        }
        out.println(validLocations);

        br.close();
        out.flush();
        out.close();
    }
}
