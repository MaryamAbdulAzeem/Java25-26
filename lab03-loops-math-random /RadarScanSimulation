/**
 * Lab 3 - Exercise 3: Radar Scan Detection Simulation
 * Simulates randomly located objects around a radar at the origin
 * and calculates the ratio detected within its circular range.
 * @version 1.0
 * @author Maryam Abdul Azeem
 */
public class RadarScanSimulation {
    public static void main(String[] args) {
        int totalObjects = 100000;
        int totalObjects2 = 1000000;
        double x;
        double y;

        // Test 1: 100,000 random objects
        int counter1 = 0;
        for (int i = 0; i < totalObjects; i++) {
            x = -1 + (Math.random() * 2); // random value between -1 and 1
            y = -1 + (Math.random() * 2);
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) { // inside detection range
                counter1++;
            }
        }

        // Test 2: 1,000,000 random objects
        int counter2 = 0;
        for (int i = 0; i < totalObjects2; i++) {
            x = -1 + (Math.random() * 2);
            y = -1 + (Math.random() * 2);
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                counter2++;
            }
        }

        double detectionRatio1 = (double) counter1 / totalObjects;
        double detectionRatio2 = (double) counter2 / totalObjects2;

        System.out.printf("Test 1 (%d scans) detection rate: %.3f%n", totalObjects, detectionRatio1);
        System.out.printf("Test 2 (%d scans) detection rate: %.3f%n", totalObjects2, detectionRatio2);

        double avg = (detectionRatio1 + detectionRatio2) / 2;
        System.out.printf("Average detection rate: %.1f%%%n", avg * 100);
    }
}
