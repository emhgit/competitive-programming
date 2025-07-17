package solutions.usacoguide.Bronze;

import java.io.*;
import java.util.*;

public class TeamTicTacToe {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/tttt.in"));
            out = new PrintWriter(new FileWriter("src/output/tttt.out"));
        } else {
            br = new BufferedReader(new FileReader("tttt.in"));
            out = new PrintWriter(new FileWriter("tttt.out"));
        }

        String[] board = new String[3];
        Set<Character> visitedChars;
        Set<String> winners = new HashSet<>();
        int individualWins = 0, teamWins = 0;

        for (int i = 0; i < 3; i++) {
            board[i] = br.readLine();
        }

        // iterate over each row
        for (int i = 0; i < board.length; i++) {
            String currStr = board[i];
            visitedChars = new HashSet<>();
            for (int j = 0; j < currStr.length(); j++) {
                visitedChars.add(currStr.charAt(j));
            }
            if (visitedChars.size() == 1 && !winners.contains(visitedChars.toString())) {
                winners.add(visitedChars.toString());
                individualWins++;
            } else if (visitedChars.size() == 2 && !winners.contains(visitedChars.toString())) {
                winners.add(visitedChars.toString());
                teamWins++;
            }
        }

        // iterate over each col
        for (int i = 0; i < board.length; i++) {
            visitedChars = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                visitedChars.add(board[j].charAt(i));
            }
            if (visitedChars.size() == 1 && !winners.contains(visitedChars.toString())) {
                winners.add(visitedChars.toString());
                individualWins++;
            } else if (visitedChars.size() == 2 && !winners.contains(visitedChars.toString())) {
                winners.add(visitedChars.toString());
                teamWins++;
            }
        }

        // iterate over left diagonal
        visitedChars = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            visitedChars.add(board[i].charAt(i));
        }

        if (visitedChars.size() == 1 && !winners.contains(visitedChars.toString())) {
            winners.add(visitedChars.toString());
            individualWins++;
        } else if (visitedChars.size() == 2 && !winners.contains(visitedChars.toString())) {
            winners.add(visitedChars.toString());
            teamWins++;
        }

        // iterate over right diagonal
        visitedChars = new HashSet<>();
        for (int i = 2, j = 0; i >= 0; i--, j++) {
            visitedChars.add(board[j].charAt(i));
        }

        if (visitedChars.size() == 1 && !winners.contains(visitedChars.toString())) {
            individualWins++;
        } else if (visitedChars.size() == 2 && !winners.contains(visitedChars.toString())) {
            teamWins++;
        }

        out.println(individualWins);
        out.println(teamWins);

        br.close();
        out.flush();
        out.close();
    }
}