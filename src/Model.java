public class Model {
    public double latitude;
    public double altitude;
    public double longitude;
    public double groundSpeed;
    public double verticalSpeed;
    public double trackAngle;
    public double timeInterval;

    public Model(double latitude, double altitude, double longitude, double groundSpeed, double verticalSpeed, double trackAngle, double timeInterval) {
        this.latitude = latitude;
        this.altitude = altitude;
        this.longitude = longitude;
        this.groundSpeed = groundSpeed;
        this.verticalSpeed = verticalSpeed;
        this.trackAngle = trackAngle;
        this.timeInterval = timeInterval;
    }

    public Model() {

    }

    public void updatePosition(double time) {
        double earthRadius = 6371000;

        double deltaLatitude = (groundSpeed / earthRadius) * (180 / Math.PI);
        double deltaLongitude = (groundSpeed / (earthRadius * Math.cos(Math.toRadians((latitude)))) * (180 / Math.PI));

        latitude += deltaLatitude;
        longitude += deltaLongitude;

        altitude += verticalSpeed * time;

    }

    public void flyLinearPath(double targetLatitude, double targetLongitude, double flightTime, double timeInterval) {
        for (double t = 0; t < flightTime; t += timeInterval) {
            updatePosition(timeInterval);
            System.out.printf("Latitude: %f, Longitude: %f, Altitude: %f%n", latitude, longitude, altitude);

            if (latitude == targetLatitude && longitude == targetLongitude) {
                System.out.println("Hedefe ulaşldı!");
                break;
            }
        }

    }
}
