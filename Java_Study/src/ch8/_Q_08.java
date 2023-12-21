package ch8;

import ch8.camera.SpeedCam;
import ch8.detector.AccidentDetector;
import ch8.reporter.VideoReporter;

public class _Q_08 {
    public static void main(String[] args) {
        SpeedCam speedCam = new SpeedCam();
        speedCam.setDetectable(new AccidentDetector());
        speedCam.setReportable(new VideoReporter());
        speedCam.detect();
        speedCam.report();
    }
}