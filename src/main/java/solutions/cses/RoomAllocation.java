package solutions.cses;

import java.io.*;
import java.util.*;

// fix this implementation 

public class RoomAllocation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> departureTimes = new TreeMap<>();
        int[] customerRooms = new int[n];
        int min = 1;

        st = new StringTokenizer(br.readLine());
        st.nextToken(); // skip arrival time, unneeded
        int initialDepartureTime = Integer.parseInt(st.nextToken());
        customerRooms[0] = 1;
        departureTimes.put(initialDepartureTime, 1);

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int arrivalTime = Integer.parseInt(st.nextToken());
            int departureTime = Integer.parseInt(st.nextToken());
            Map.Entry<Integer, Integer> entry = departureTimes.lowerEntry(arrivalTime);
            if (entry != null) {
                customerRooms[i] = entry.getValue();
            } else {
                min++;
                customerRooms[i] = min;
                departureTimes.put(departureTime, min);
            }
        }

        out.println(min);
        for (int room : customerRooms)
            out.print(room + " ");

        br.close();
        out.flush();
        out.close();
    }
}