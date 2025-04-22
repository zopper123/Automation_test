package utils;

import java.util.concurrent.TimeUnit;

public class PerformanceTestUtility {

    private long startTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void endTimer(String label) {
        long duration = System.nanoTime() - startTime;
        System.out.println(label + " execution time: " + TimeUnit.NANOSECONDS.toMillis(duration) + " ms");
    }
}
