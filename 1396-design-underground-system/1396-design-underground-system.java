class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkInMap;
    private Map<String,RouteInfo> routeMap;
    private static class CheckInInfo{
        String stationName;
        int checkInTime;
        CheckInInfo(String stationName, int checkInTime){
            this.stationName=stationName;
            this.checkInTime=checkInTime;
        }
    }
    private static class RouteInfo {
        double totalTime;
        int tripCount;
        RouteInfo(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkIn = checkInMap.remove(id);
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.checkInTime;
        RouteInfo route = routeMap.getOrDefault(routeKey, new RouteInfo(0, 0));
        route.totalTime += travelTime;
        route.tripCount += 1;
        routeMap.put(routeKey, route);
    } 
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeMap.get(routeKey);
        return route.totalTime / route.tripCount;
    }
}