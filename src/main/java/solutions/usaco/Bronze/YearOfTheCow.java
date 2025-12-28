package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class YearOfTheCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        Map<String, Integer> animalsToIdx = Map.ofEntries(
                Map.entry("Ox", 1),
                Map.entry("Tiger", 2),
                Map.entry("Rabbit", 3),
                Map.entry("Dragon", 4),
                Map.entry("Snake", 5),
                Map.entry("Horse", 6),
                Map.entry("Goat", 7),
                Map.entry("Monkey", 8),
                Map.entry("Rooster", 9),
                Map.entry("Dog", 10),
                Map.entry("Pig", 11),
                Map.entry("Rat", 12));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> namesToYears = new HashMap<>();
        namesToYears.put("Bessie", 0);
        Map<String, String> namesToAnimals = new HashMap<>();
        namesToAnimals.put("Bessie", "Ox");
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            String previousAnimal;
            if (i == 0) {
                previousAnimal = "Bessie";
            } else {
                previousAnimal = in[in.length - 1];
            }
            int years;
            if (in[3].equals("previous")) {
                if (animalsToIdx.get(in[4]) > animalsToIdx.get(namesToAnimals.get(previousAnimal))) {
                    years = namesToYears.get(previousAnimal) - (12 - animalsToIdx.get(in[4]))
                            - animalsToIdx.get(namesToAnimals.get(previousAnimal));
                } else if (animalsToIdx.get(in[4]) == animalsToIdx.get(namesToAnimals.get(previousAnimal))) {
                    years = namesToYears.get(previousAnimal) - 12;
                } else {
                    years = namesToYears.get(previousAnimal)
                            - (animalsToIdx.get(namesToAnimals.get(previousAnimal)) - animalsToIdx.get(in[4]));
                }
            } else {
                if (animalsToIdx.get(in[4]) < animalsToIdx.get(namesToAnimals.get(previousAnimal))) {
                    years = namesToYears.get(previousAnimal)
                            + (12 - animalsToIdx.get(namesToAnimals.get(previousAnimal))) + animalsToIdx.get(in[4]);
                } else if (animalsToIdx.get(in[4]) == animalsToIdx.get(namesToAnimals.get(previousAnimal))) {
                    years = namesToYears.get(previousAnimal) + 12;
                } else {
                    years = namesToYears.get(previousAnimal) + (animalsToIdx.get(in[4]))
                            - animalsToIdx.get(namesToAnimals.get(previousAnimal));
                }
            }
            namesToYears.put(in[0], years);
            namesToAnimals.put(in[0], in[4]);
            if (in[0].equals("Elsie")) {
                break;
            }
        }
        out.println(Math.abs(namesToYears.get("Elsie")));
        out.close();
    }
}
