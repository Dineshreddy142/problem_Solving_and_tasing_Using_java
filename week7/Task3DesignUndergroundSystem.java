import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3DesignUndergroundSystem {
    static class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    static class TripStats {
        long totalTime;
        int count;

        void addTrip(int time) {
            totalTime += time;
            count++;
        }

        double average() {
            return (double) totalTime / count;
        }
    }

    static class UndergroundSystem {
        private final Map<Integer, CheckInInfo> active = new HashMap<>();
        private final Map<String, TripStats> stats = new HashMap<>();

        public void checkIn(int id, String stationName, int t) {
            active.put(id, new CheckInInfo(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            CheckInInfo in = active.remove(id);
            String key = in.station + "->" + stationName;
            TripStats trip = stats.computeIfAbsent(key, k -> new TripStats());
            trip.addTrip(t - in.time);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "->" + endStation;
            return stats.get(key).average();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int q = scanner.nextInt();
        UndergroundSystem us = new UndergroundSystem();

        for (int i = 0; i < q; i++) {
            String op = scanner.next();
            if (op.equals("checkIn")) {
                int id = scanner.nextInt();
                String station = scanner.next();
                int t = scanner.nextInt();
                us.checkIn(id, station, t);
            } else if (op.equals("checkOut")) {
                int id = scanner.nextInt();
                String station = scanner.next();
                int t = scanner.nextInt();
                us.checkOut(id, station, t);
            } else if (op.equals("getAverageTime")) {
                String start = scanner.next();
                String end = scanner.next();
                System.out.printf("%.5f%n", us.getAverageTime(start, end));
            }
        }
    }
}
