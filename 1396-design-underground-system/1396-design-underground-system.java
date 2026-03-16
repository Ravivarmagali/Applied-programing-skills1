import java.util.*;

class UndergroundSystem {

    // store check-in info: id -> (station, time)
    Map<Integer, Pair> checkInMap;

    // store route info: "start-end" -> (totalTime, count)
    Map<String, int[]> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);
        checkInMap.remove(id);

        String startStation = p.station;
        int startTime = p.time;

        int travelTime = t - startTime;

        String key = startStation + "-" + stationName;

        routeMap.putIfAbsent(key, new int[2]);

        routeMap.get(key)[0] += travelTime; // total time
        routeMap.get(key)[1] += 1;          // trip count
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        int[] data = routeMap.get(key);

        return (double) data[0] / data[1];
    }

    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}