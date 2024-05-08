public class Main {
    public static void main(String[] args) {
        double targetLatitude = 41.8781;
        double targetLongitude = -87.6298;
        double flightTime = 3600;//1saat
        double timeInterval = 1000;


        double startLatitude = 40.7128;
        double startLongitude = -74.0060;
        double startAltitude = 100; // metre cinsinden

        Model model = new Model(startLatitude, startLongitude, startAltitude,timeInterval, 10, 2, 0);

        model.flyLinearPath(targetLatitude, targetLongitude, flightTime, timeInterval);

        }
}